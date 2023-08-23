package com.blog.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity  // 시큐리티 활성화 -> 기본 스프링 필터체인에 등록
public class SecurityConfig {

  @Bean
  BCryptPasswordEncoder encode() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(CsrfConfigurer::disable)
      .authorizeHttpRequests(
        authorize -> authorize
          .requestMatchers(AntPathRequestMatcher.antMatcher("/api/**")).authenticated()
          .anyRequest().permitAll())
      .formLogin(
        login -> login
          .loginPage("/auth/loginForm").permitAll()
          .loginProcessingUrl("/auth/loginProc")  // spring security 가 해당 url로 login 가로챔
          .defaultSuccessUrl("/")
        );  

    return http.build();
  }
}
