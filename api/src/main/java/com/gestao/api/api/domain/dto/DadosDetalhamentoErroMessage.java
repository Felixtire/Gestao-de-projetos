package com.gestao.api.api.domain.dto;

public record DadosDetalhamentoErroMessage(String erro) {

    public DadosDetalhamentoErroMessage(Error e){
        this(e.getMessage());
    }
}
