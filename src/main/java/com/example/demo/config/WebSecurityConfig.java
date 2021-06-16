package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;
    private final TokenProvider tokenProvider;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().addFilter(corsFilter)
            .formLogin().disable()
            .httpBasic().disable() //Authorization Basic 방식 사용 안함 -> Authorization Bearer 방식 사용
            .addFilterBefore(new StatelessAuthenticationFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .anyRequest().permitAll()
            ;

    }
}
