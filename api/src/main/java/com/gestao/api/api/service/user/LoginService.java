package com.gestao.api.api.service.user;

import com.gestao.api.api.domain.dto.user.DadosLoginUsuario;
import com.gestao.api.api.infra.security.ServiceToken;
import com.gestao.api.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ServiceToken serviceToken;

    public String login(DadosLoginUsuario dados){

        var usuario = repository.findByLogin(dados.login())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dados.senha(), usuario.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        return serviceToken.generateToken(usuario);
    }
}
