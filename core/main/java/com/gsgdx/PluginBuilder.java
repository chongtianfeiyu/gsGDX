package com.gsgdx;

import java.util.Set;

public abstract class PluginBuilder {

	
	public Plugin build() {

		Plugin plugin = new Plugin();
		plugin.setName(getPluginName());
		plugin.setElements(getElements());
		
		return plugin;
	}
	
	abstract public Set<Class<?>> getElements();
	

	
	abstract public String getPluginName();

	
}
