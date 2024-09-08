package com.example.dipractice.di;


import static org.reflections.ReflectionUtils.*;

import java.lang.reflect.Constructor;
import java.util.Set;

import org.reflections.util.ReflectionUtilsPredicates;

import com.example.dipractice.annotation.Inject;


public class BeanFactoryUtils {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Constructor<?> getInjectedConstructor(Class<?> clazz) {
        Set<Constructor> injectedConstructors = getAllConstructors(clazz, ReflectionUtilsPredicates.withAnnotation(
            Inject.class));
        if (injectedConstructors.isEmpty()) {
            return null;
        }
        return injectedConstructors.iterator().next();
    }
}
