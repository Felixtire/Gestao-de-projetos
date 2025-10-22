package com.gestao.api.api.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDto(

        @NotBlank
        @Email(message = "Formato do email é inválido")
        String login,

        @NotBlank
        String senha,

        @NotBlank
        String nome,

        @NotNull
        int idade





) {
}
