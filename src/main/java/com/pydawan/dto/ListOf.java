package com.pydawan.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation should be used on fields of {@link Dto}s that are lists of other {@link Dto}s.
 * The value of the annotation must be the type of the list elements.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListOf {
    Class<?> value();

}
