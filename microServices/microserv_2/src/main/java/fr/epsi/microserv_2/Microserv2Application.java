package fr.epsi.microserv_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.List;

@RestController
@SpringBootApplication
@EnableCircuitBreaker
public class Microserv2Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Microserv2Application.class, args);
    }

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/loadbal")
    public String method()
    {
        ServiceInstance serviceInstance = loadBalancer.choose("microserv_1");
        return serviceInstance.getUri().toString();
    }

    @HystrixCommand(fallbackMethod = "defaultMessage")
    @GetMapping("/")
    public String hello()
    {
        List<ServiceInstance>  instances          = discoveryClient.getInstances("microserv_1");
        System.out.println(instances.get(0).toString());
        ServiceInstance        test               = instances.get(0);
        String                 hostname           = test.getHost();
        int                    port               = test.getPort();
        RestTemplate           restTemplate       = new RestTemplate();
        String                 microserv1_Address = "http://" + hostname + ":" + port;
        ResponseEntity<String> response           = restTemplate.getForEntity(microserv1_Address, String.class);
        String                 s                  = response.getBody();

        return s;
    }

    public String defaultMessage()
    {
        return "default message";
    }
}
