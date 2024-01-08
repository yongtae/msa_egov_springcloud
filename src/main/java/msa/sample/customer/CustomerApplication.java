package msa.sample.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient // eureka client 적용
@ComponentScan("msa.*")
@SpringBootApplication
public class CustomerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
