package com.springboot.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerTraceReqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerTraceReqApplication.class, args);
	}

}
