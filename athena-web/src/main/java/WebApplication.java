


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ImportResource;



@SpringBootApplication(scanBasePackages="com.test.controller")
@ImportResource(locations = {"dubbo-consumer.xml"})
public class WebApplication {


    /**
     * Main Start
     */
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        System.out.println("============= SpringBoot web Start Success =============");
    }
}
