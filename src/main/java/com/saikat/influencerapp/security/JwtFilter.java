package com.saikat.influencerapp.security;

import com.saikat.influencerapp.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String path = req.getRequestURI();

        if (path.contains("/auth/login") || path.contains("/auth/signup")) {
            chain.doFilter(request, response);
            return;
        }

        String authHeader = req.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {
                String email = jwtUtil.extractEmail(token);

                req.setAttribute("email", email);

            } catch (Exception e) {
                throw new RuntimeException("Invalid Token");
            }
        } else {
            throw new RuntimeException("Missing Authorization Header");
        }

        chain.doFilter(request, response);
    }
}