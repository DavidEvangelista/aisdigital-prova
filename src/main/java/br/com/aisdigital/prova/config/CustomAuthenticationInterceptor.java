package br.com.aisdigital.prova.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class CustomAuthenticationInterceptor implements RequestInterceptor {

    @Value("${security.api_key}")
    private String apiKey;

    @Value("${default.language}")
    private String language;


    public void apply(RequestTemplate template) {
        template.query("api_key", this.apiKey);
        template.query("language", this.language);
    }

}
