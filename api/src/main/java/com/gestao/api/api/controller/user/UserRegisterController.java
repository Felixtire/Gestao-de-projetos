package com.gestao.api.api.controller.user;

import com.gestao.api.api.domain.dto.user.DadosCadastroConcluido;
import com.gestao.api.api.domain.dto.user.DadosCadastroDto;
import com.gestao.api.api.service.user.RegisterService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar")
public class UserRegisterController {

    @Autowired
    private RegisterService service;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DadosCadastroDto dadosCadastroDto){

        var userRegister = service.cadastrar(dadosCadastroDto);

        return ResponseEntity.ok().body(new DadosCadastroConcluido(userRegister));
    }
}
