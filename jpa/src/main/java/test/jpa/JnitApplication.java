package test.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JnitApplication.class, args);
	}

}
