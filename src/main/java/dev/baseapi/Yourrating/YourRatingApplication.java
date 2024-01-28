package dev.baseapi.Yourrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // см. класс Comment
public class YourRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourRatingApplication.class, args);
	}

}
