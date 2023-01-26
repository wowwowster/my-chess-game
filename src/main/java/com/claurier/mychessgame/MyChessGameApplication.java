package com.claurier.mychessgame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MyChessGameApplication {

	private static final Logger logger = LoggerFactory.getLogger(com.claurier.mychessgame.MyChessGameApplication.class);

	public static void main(String[] args) {

		// semble encapsuler SpringApplication.run(MyChessGameApplication.class, args);
		configureApplication(new SpringApplicationBuilder(), new DefaultApplicationArguments(args)).run(args);
	}

	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder, ApplicationArguments args) {
		logger.info("Application started with the following arguments:");
		for (String name : args.getOptionNames()) {
			logger.info(name + " -> " + args.getOptionValues(name));
		}

		Map<String, Object> properties = new HashMap<>();

		if (args.getOptionNames().contains("dropFirst")) {
			properties.put("liquibase.drop-first", args.getOptionValues("dropFirst"));
		}

		return builder
				.properties(properties)
				.sources(com.claurier.mychessgame.MyChessGameApplication.class);
	}
}

