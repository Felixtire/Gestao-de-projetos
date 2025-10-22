package com.gestao.api.api.domain.dto.user;

import com.gestao.api.api.domain.user.UserEntity;
import jakarta.validation.Valid;
import org.apache.catalina.User;

public record DadosCadastroConcluido(String login, String nome) {

    public DadosCadastroConcluido(UserEntity user){
        this(user.getLogin(), user.getNome());
    }

}
