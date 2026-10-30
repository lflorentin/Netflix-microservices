package com.example.TPNetflix.TPnetflixmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TpNetflixMicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TpNetflixMicroserviceApplication.class, args);
	}

}
