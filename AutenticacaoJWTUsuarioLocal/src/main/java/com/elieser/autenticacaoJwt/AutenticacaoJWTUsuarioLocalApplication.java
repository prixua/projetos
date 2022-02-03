package com.elieser.autenticacaoJwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Import(WebSecurityConfig.class)
public class AutenticacaoJWTUsuarioLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutenticacaoJWTUsuarioLocalApplication.class, args);
    }

}
