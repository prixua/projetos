package com.elieser.pontointeligente.api;

import com.elieser.pontointeligente.api.security.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebSecurityConfig.class)
public class PontoInteligente1Application {

	public static void main(String[] args) {
		SpringApplication.run(PontoInteligente1Application.class, args);
	}

}
