package com.elieser.autenticacaoJwt.controller;

import com.elieser.autenticacaoJwt.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response testaAuth(@PathVariable Long id){
        Response resp = new Response();
        resp.setStatus(HttpStatus.OK);
        resp.setData("Seu id foi "+id);
        resp.setMessage("Parabéns!");
        return resp;
    }
}
