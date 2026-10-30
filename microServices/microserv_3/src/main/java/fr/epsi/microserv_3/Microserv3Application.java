package fr.epsi.microserv_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@EnableZuulProxy
@EnableWebSecurity
public class Microserv3Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Microserv3Application.class, args);
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception
    {
        UserDetails user =
            User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();

        return new InMemoryUserDetailsManager(user);
    }
}
