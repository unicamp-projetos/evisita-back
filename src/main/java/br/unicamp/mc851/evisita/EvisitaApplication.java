package br.unicamp.mc851.evisita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class EvisitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvisitaApplication.class, args);
	}

}
