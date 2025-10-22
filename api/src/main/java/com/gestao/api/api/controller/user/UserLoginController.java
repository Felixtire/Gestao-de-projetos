package com.gestao.api.api.controller.user;

import com.gestao.api.api.domain.dto.user.DadosLoginUsuario;
import com.gestao.api.api.domain.dto.infra.TokenAuthenticationJwt;
import com.gestao.api.api.service.user.LoginService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    @Autowired
    private LoginService service;

    @PostMapping
    @Transactional
    public ResponseEntity<TokenAuthenticationJwt> login(@RequestBody @Valid DadosLoginUsuario dados){

        String token = service.login(dados);

        return ResponseEntity.ok(new TokenAuthenticationJwt(token));
    }
}
