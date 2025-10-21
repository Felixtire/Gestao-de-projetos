package com.gestao.api.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.gestao.api.api.domain.user.UserEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class ServiceToken {

    private String secret = "123456";

    public String generateToken(UserEntity user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Gestao.proj")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dataLimite())
                    .withClaim("id",user.getId())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o tóken");

        }
    }

    public String getSubject(String tokenJwt){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("API Gestao.proj")
                    .build()
                    .verify(tokenJwt)
                    .getSubject();

        }catch (JWTCreationException exception){
            throw new RuntimeException("Tóken inválido ou expirado");
        }

    }

    private Instant dataLimite() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
