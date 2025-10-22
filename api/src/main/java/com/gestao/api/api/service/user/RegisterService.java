package com.gestao.api.api.service.user;

import com.gestao.api.api.domain.dto.DadosCadastroDto;
import com.gestao.api.api.domain.user.UserEntity;
import com.gestao.api.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository repository;


    public UserEntity cadastrar(DadosCadastroDto dados){
        var usuario= new UserEntity(dados);

        return repository.save(usuario);
    }





}
