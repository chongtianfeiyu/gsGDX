package com.gsgdx;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.badlogic.gdx.files.FileHandle;
import com.gsgdx.annotations.Element;

public class ReflectionsPluginBuilder extends PluginBuilder {

	private FileHandle pluginDir;
	private Reflections reflections;
	
	public ReflectionsPluginBuilder(FileHandle pluginDir) throws IOException {
		if(!pluginDir.isDirectory()) {
			throw new IllegalArgumentException("The given path for pluginDir is not a directory");
		}
		this.pluginDir = pluginDir;
		
		ClassLoader classLoader = createClassLoaderFromDirectory();
		
		ConfigurationBuilder reflectionsConfigurationBuilder = new ConfigurationBuilder();
		
		reflectionsConfigurationBuilder
			.setUrls(ClasspathHelper.forClassLoader(classLoader))
			.addClassLoader(classLoader);
		
		reflections = new Reflections(reflectionsConfigurationBuilder);
	}
	
	private ClassLoader createClassLoaderFromDirectory() throws IOException {
		URL[] urlArray = getJarUrls();
		return new URLClassLoader(urlArray);
	}
	
	private URL[] getJarUrls() throws IOException {
		List<URL> urlList = new ArrayList<>();
		
		for(FileHandle jarFile : pluginDir.list(".jar")) {
			URL url = toURL(jarFile);
			urlList.add(url);
		}
		
		return urlList.toArray(new URL[urlList.size()]);
	}
	
	private URL toURL(FileHandle file) throws IOException {
		return file.file().toURI().toURL();
	}

	@Override
	protected void loadElements() {
		setElements(reflections.getTypesAnnotatedWith(Element.class));
	}

	@Override
	protected void loadPluginName() {
		setPluginName(pluginDir.name());
	}

}
