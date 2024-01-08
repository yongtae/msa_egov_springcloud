package msa.sample.catalogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("msa.*")
@EnableCircuitBreaker // Hystrix 적용
@EnableEurekaClient // eureka client 적용
@SpringBootApplication
public class CatalogsApplication {
	
	@Bean
	@LoadBalanced // ribbon 적용
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogsApplication.class, args);
	}

}
