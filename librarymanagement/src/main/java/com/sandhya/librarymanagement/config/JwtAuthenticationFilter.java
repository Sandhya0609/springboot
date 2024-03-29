package com.sandhya.librarymanagement.config;


import com.sandhya.librarymanagement.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        if(request.getServletPath().contains("")){
            filterChain.doFilter(request,response);
        }

        final String authHeader=request.getHeader("Authorization");

        final  String jwt;
        final String userEmail;

        if(authHeader==null || !authHeader.startsWith("Bearer")){
            return;
        }
        jwt=authHeader.substring(7);
        userEmail=jwtService.extractUsername(jwt);
    }
}
