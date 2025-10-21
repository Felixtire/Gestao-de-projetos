package com.gestao.api.api.infra.security;

import com.gestao.api.api.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private ServiceToken service;
    @Autowired
    private UserRepository repository;

    protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain){
        var tokenJwt = tokenRecover(request);

        if (tokenJwt != null){
            var subject = service.getSubject(tokenJwt);

            var user = repository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }


    }

    private String tokenRecover(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader !=null){
            return authorizationHeader.replace("Bearer", "").trim();
        }
        return null;
    }
}
