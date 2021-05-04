package br.unicamp.mc851.evisita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableFeignClients
@EnableSwagger2
public class EvisitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvisitaApplication.class, args);
	}

}
