package com.gsgdx;

import java.util.Set;

public class Plugin {

	private String name;
	
	private Set<Class<?>> elements;
	
	Plugin() {

	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Class<?>> getElements() {
		return elements;
	}
	
	public void setElements(Set<Class<?>> elements) {
		this.elements = elements;
	}
	
}
