package com.example.demo.config;

import com.example.demo.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class StatelessAuthenticationFilter extends GenericFilterBean {

    private TokenProvider tokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String token = ((HttpServletRequest) request).getHeader(TokenProvider.BEARER_JWT_KEY_NAME).replaceAll(TokenProvider.BEARER_JWT_PREFIX, "");

        if(!StringUtil.hasValue(token)) chain.doFilter(request, response);
        else {
            UserAuthentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }


}
