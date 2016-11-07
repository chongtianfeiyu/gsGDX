package com.gsgdx;

import java.util.HashSet;
import java.util.Set;

public abstract class PluginBuilder {

	private String pluginName;
	
	private Set<Class<?>> elements = new HashSet<>();
	
	public Plugin build() {
		loadPluginName();
		loadElements();
		
		Plugin plugin = new Plugin();
		plugin.setName(pluginName);
		plugin.setElements(elements);
		
		return plugin;
	}
	
	public Set<Class<?>> getElements() {
		return elements;
	}
	
	protected void setElements(Set<Class<?>> elements) {
		this.elements = elements;
	}
	
	public String getPluginName() {
		return pluginName;
	}
	
	protected void setPluginName(String name) {
		this.pluginName = name;
	}
	
	protected abstract void loadElements();
	
	protected abstract void loadPluginName();
	
}
