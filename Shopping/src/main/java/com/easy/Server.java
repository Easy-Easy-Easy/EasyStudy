package com.easy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server {
	private static Log log = LogFactory.getLog(Server.class);

	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
		log.info("启动成功!");
	}
}
