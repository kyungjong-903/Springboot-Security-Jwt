package com.example.demo.config;

import com.example.demo.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class StatelessAuthenticationFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {

        String token = getToken(request);

        if(StringUtil.hasValue(token) && tokenProvider.validateToken(token)) {
            UserAuthentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    public String getToken(HttpServletRequest request) {
        String token = request.getHeader(TokenProvider.BEARER_JWT_KEY_NAME);
        if(!StringUtil.hasValue(token)) return null;
        return token.replaceAll(TokenProvider.BEARER_JWT_PREFIX, "");
    }


}
