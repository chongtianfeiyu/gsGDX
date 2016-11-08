package com.gsgdx;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.badlogic.gdx.files.FileHandle;

public class ReflectionsPluginBuilderTest {

	private final String resourcesPath = "test/resources/";
	private final String testJarFileName = "test.jar";
	
	@Test(expected=IllegalArgumentException.class)
	public void testThrowsExceptionIfFileGivenOnConstruct() throws IOException {
		
		FileHandle file = new FileHandle(resourcesPath + testJarFileName);
		
		new ReflectionsPluginBuilder(file);
		
		fail();
	}
	
	@Test
	public void testElementsAreLoaded() throws IOException {
		
		FileHandle dir = new FileHandle(resourcesPath);
		PluginBuilder builder = new ReflectionsPluginBuilder(dir);
		
		Plugin plugin = builder.build();
		
		assertTrue(plugin.getElements().size() == 1);
		assertTrue(plugin.getElements().iterator().next().getSimpleName().equals("TestClass1"));
	}
	
	@Test
	public void testNameIsSet() throws IOException {
	
		FileHandle dir = new FileHandle(resourcesPath);
		PluginBuilder builder = new ReflectionsPluginBuilder(dir);
		
		Plugin plugin = builder.build();
		
		assertTrue(plugin.getName().equals("resources"));
		
	}

}
