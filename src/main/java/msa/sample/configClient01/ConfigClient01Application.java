package msa.sample.configClient01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClient01Application {

	public static void main(String[] args) {

//		String profile = System.getProperty("spring.profiles.active");
//		if (profile == null) {
//			System.setProperty("spring.profiles.active", "dev");
//		}

		SpringApplication.run(ConfigClient01Application.class, args);
	}

}
