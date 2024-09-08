package com.example.dipractice.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class BeanFactory {
    private Set<Class<?>> preInstantiatedBeans;

    private Map<Class<?>, Object> beans = new HashMap<>();

    public BeanFactory(Set<Class<?>> preInstantiatedBeans) {
        this.preInstantiatedBeans = preInstantiatedBeans;
        initialize();
    }

    public void initialize() {
        for (Class<?> clazz : preInstantiatedBeans) {
            Object instance = createInstance(clazz);
            beans.put(clazz, instance);
        }
    }

    private Object createInstance(Class<?> concreteClass) {
        Constructor<?> constructor = findConstructor(concreteClass);
        List<Object> parameters = new ArrayList<>();

        for (Class<?> typeClass : Objects.requireNonNull(constructor).getParameterTypes()) {
            parameters.add(getParameterByClass(typeClass));
        }

        try {
            return constructor.newInstance(parameters.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Constructor<?> findConstructor(Class<?> concreteClass) {
        Constructor<?> constructor = BeanFactoryUtils.getInjectedConstructor(concreteClass);

        if (Objects.nonNull(constructor)) {
            return constructor;
        }

        return concreteClass.getConstructors()[0];
    }

    private Object getParameterByClass(Class<?> typeClass) {
        Object instanceBean = getBean(typeClass);
        if(Objects.nonNull(instanceBean)) {
            return instanceBean;
        }
        return createInstance(typeClass);
    }

    public <T> T getBean(Class<T> requiredType) {
        return (T) beans.get(requiredType);
    }
}

