package com.gestao.api.api.domain.dto;

import org.springframework.validation.FieldError;

public record DadosDetalhamentoErro(String field , String message) {

    public DadosDetalhamentoErro(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
