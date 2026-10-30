package fr.epsi.microserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MicroservApplication.class, args);
	}
}
