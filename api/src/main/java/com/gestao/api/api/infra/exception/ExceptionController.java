package com.gestao.api.api.infra.exception;

import com.gestao.api.api.domain.dto.DadosDetalhamentoErroMessage;
import com.gestao.api.api.domain.dto.DadosDetalhamentoErro;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratando404(){
        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratando400(MethodArgumentNotValidException ex){
        var erro = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(DadosDetalhamentoErro:: new).toList());

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity tratando500(NullPointerException ex){
        var erro = ex.getMessage();

        return ResponseEntity.internalServerError().body(new DadosDetalhamentoErroMessage(erro));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity tratandoErroDeConversaoJson(HttpMessageNotReadableException ex){
        var erro = ex.getMessage();
        return ResponseEntity.badRequest().body(new DadosDetalhamentoErroMessage(erro));
    }
}
