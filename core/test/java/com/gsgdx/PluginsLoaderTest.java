package com.gsgdx;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class PluginsLoaderTest {

	private final String resourcesPath = "test/resources/";
	private final String pluginsPath = resourcesPath + "plugins/";
	private final String testJarFileName = "test.jar";
	
	@Test(expected=IllegalArgumentException.class)
	public void testThrowsExceptionIfFileGivenOnConstruct() {
		new PluginsLoader(resourcesPath + testJarFileName);
		
		fail();
	}
	
	@Test
	public void testPluginIsLoaded() {
		PluginsLoader loader = new PluginsLoader(pluginsPath);
		
		Set<Plugin> plugins = loader.getPlugins();
		
		assertTrue(plugins.size() == 3);
	}

}
