package com.elieser.autenticacaoJwt.services;

import com.elieser.autenticacaoJwt.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private Environment env;

    public Optional<User> buscarPorUsuario(String username) {

        if(!username.equals(env.getProperty("auth.username")))
            return null;

        User user = new User();
        user.setUsername(username);
        user.setSenha(env.getProperty("auth.password"));
        return Optional.of(user);
    }
}
