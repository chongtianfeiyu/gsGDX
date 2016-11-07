package com.gsgdx.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to mark types as elements.
 * Elements are subjects to dependency injection and will
 * be instantiated at startup. They are accessible through
 * the container that comes with artemis. If no value String
 * is provided they will be registered under their class name.
 * @author Chris
 */

@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Element {
	String value();
}
