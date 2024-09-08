package com.example.dipractice;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import com.example.dipractice.annotation.Controller;
import com.example.dipractice.annotation.Service;
import com.example.dipractice.di.BeanFactory;

public class BeanFactoryTest {
	private Reflections reflections;
	private BeanFactory beanFactory;

	@BeforeEach
	public void setup() {
		reflections = new Reflections("org.example");
		Set<Class<?>> preInstantiatedClazz = getTypesAnnotatedWith(Controller.class, Service.class);
		beanFactory = new BeanFactory(preInstantiatedClazz);
	}

	private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations) {
		return Arrays.stream(annotations)
			.flatMap(annotation -> reflections.getTypesAnnotatedWith(annotation).stream())
			.collect(Collectors.toSet());
	}

	@Test
	public void diTest() {
		UserController userController = beanFactory.getBean(UserController.class);

		/*assertThat(userController).isNotNull();
		assertThat(userController.getUserService()).isNotNull();*/

		assertNotNull(userController.getUserService());
	}
}
