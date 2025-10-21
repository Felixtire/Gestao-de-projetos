package com.gestao.api.api.controller.user;

import com.gestao.api.api.domain.dto.DadosLoginUsuario;
import com.gestao.api.api.domain.dto.TokenAuthenticationJwt;
import com.gestao.api.api.domain.user.UserEntity;
import com.gestao.api.api.infra.security.ServiceToken;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private ServiceToken serviceToken;

    @PostMapping
    @Transactional
    public ResponseEntity login(@RequestBody @Valid DadosLoginUsuario dados){

        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());

        var authentication = manager.authenticate(token);

        var tokenDto = serviceToken.generateToken((UserEntity) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenAuthenticationJwt(tokenDto));
    }



}
