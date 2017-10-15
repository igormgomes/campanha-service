package br.com.campanha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CampanhaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampanhaServiceApplication.class, args);
	}
}
