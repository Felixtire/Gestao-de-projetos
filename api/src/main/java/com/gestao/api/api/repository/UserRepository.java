package com.gestao.api.api.repository;

import com.gestao.api.api.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserDetails findByLogin(String login);
}
