package com.gestao.api.api.service.user;

import com.gestao.api.api.domain.dto.user.DadosCadastroDto;
import com.gestao.api.api.domain.user.UserEntity;
import com.gestao.api.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;


    public UserEntity cadastrar(DadosCadastroDto dados){
        var usuario= new UserEntity(dados);
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return repository.save(usuario);

    }





}
