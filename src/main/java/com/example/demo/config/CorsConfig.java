package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); //서버 응답시 json을 자바스크립트에서 처리할수있게 할지 설
        config.addAllowedOrigin("*"); // 모든(*) IP에 응답허용
        config.addAllowedHeader("*"); // 모든(*) header에 응답허용
        config.addAllowedMethod("*"); // 모든(*) Methods에 응답허용
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
