package com.example.ProyectorIntegradorRenatoBicego;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ProyectorIntegradorRenatoBicegoApplication {
	private static final Logger logger = Logger.getLogger(ProyectorIntegradorRenatoBicegoApplication.class);

	public static void main(String[] args) {
		File log4jfile = new File("./src/main/resources/log4j.properties");
		PropertyConfigurator.configure(log4jfile.getAbsolutePath());
		SpringApplication.run(ProyectorIntegradorRenatoBicegoApplication.class, args);
	}

}
