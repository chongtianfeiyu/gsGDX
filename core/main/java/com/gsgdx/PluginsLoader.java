package com.gsgdx;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class PluginsLoader {
	
	private final static String TAG = PluginsLoader.class.getSimpleName();

	private FileHandle pluginDir;
	private Set<Plugin> loadedPlugins;
	
	public PluginsLoader(String pluginDirPath) throws IllegalArgumentException {
		
		this.pluginDir = new FileHandle(pluginDirPath);
		
		if(!pluginDir.isDirectory()) {
			throw new IllegalArgumentException("The given path for pluginDir is not a directory");
		}
		
	}
	
	public Set<Plugin> getPlugins() {
		loadedPlugins = new HashSet<>();
		for(FileHandle pluginPath : pluginDir.list(new DirectoryFileFilter())) {
			loadPluginFromPath(pluginPath);
		}
		return loadedPlugins;
	}

	private void loadPluginFromPath(FileHandle pluginPath) {
		try {
			PluginBuilder pluginBuilder = new ReflectionsPluginBuilder(pluginPath);
			Plugin plugin = pluginBuilder.build();
			loadedPlugins.add(plugin);
		} catch (IOException e) {
			Gdx.app.log(TAG, "Could not load Plugin at path " + pluginPath, e);
		}
	}

		
}
