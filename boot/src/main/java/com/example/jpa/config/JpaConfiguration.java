package com.example.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.jpa.repository")
public class JpaConfiguration {

    @Bean
    public SpringSecurityAuditorAware auditorAware() {
        return new SpringSecurityAuditorAware();
    }

}
