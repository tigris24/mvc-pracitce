package com.example.calculatorweb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomWebApplicationServer {
	public static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);
	private final int port;
	private final ExecutorService executorService = Executors.newFixedThreadPool(10);

	public CustomWebApplicationServer(int port) {
		this.port = port;
	}

	public void start() throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			logger.info("[CustomWebApplicationServer] started {} port.", port);

			Socket clientSocket;
			logger.info("[CustomWebApplicationServer] waiting for client.");

			while ((clientSocket = serverSocket.accept()) != null) {
				logger.info("[CustomWebApplicationServer] client connected!");

				/**
				 *  Step1 - 사용자 요청을 메인 Thread 가 처리하도록 한다.
				 */
				/*
				String line;
				while ((line = br.readLine()) != "") {
					System.out.println(line);
				}*/

				/**
				 * Step2 - 사용자 요청이 들어올 때마다 Thread 를 새로 생성해서 사용자 요청을 처리하도록 한다.
				 */
				// new Thread(new ClientRequestHandler(clientSocket)).start();

				/**
				 * Step3 - Thread Pool 을 적용해 안정적인 서비스가 가능하도록 한다.
				 */
				executorService.execute(new ClientRequestHandler(clientSocket));


			}
		}
	}

}
