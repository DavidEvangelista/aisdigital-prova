package br.com.aisdigital.prova.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class ProvaConfiguration {

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder().propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    @Bean
    public CustomAuthenticationInterceptor customAuthenticationInterceptor() {
        return new CustomAuthenticationInterceptor();
    }

}
