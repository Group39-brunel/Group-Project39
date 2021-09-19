package com.example.genderdecoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GenderDecoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenderDecoderApplication.class, args);
	}

}
