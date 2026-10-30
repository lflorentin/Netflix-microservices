package fr.epsi.microserv_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Microserv1Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Microserv1Application.class, args);
    }

    @RequestMapping
    public String hello()
    {
        return "Hello";
    }
}
