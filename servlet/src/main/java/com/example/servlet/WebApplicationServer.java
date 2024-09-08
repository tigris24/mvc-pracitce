package com.example.servlet;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApplicationServer {

	public static final Logger logger = LoggerFactory.getLogger(WebApplicationServer.class);

	public static void main(String[] args) throws LifecycleException {
		String webappDirLocation = "webapps/";
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);

		tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
		logger.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());

		tomcat.start();
		tomcat.getServer().await();
	}
}
