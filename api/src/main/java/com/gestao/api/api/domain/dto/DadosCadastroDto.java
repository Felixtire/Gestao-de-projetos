package com.gestao.api.api.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroDto(

        @NotBlank
        @Email(regexp = "/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$/",
        message = "Formato do email é inválido")
        String login,

        @NotBlank
        String senha,

        @NotBlank
        String nome,

        @NotBlank
        String idade





) {
}
