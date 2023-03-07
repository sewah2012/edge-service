package io.sewah.edgeservice.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class config {

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http){
        return http
                .authorizeExchange(exchange -> exchange.anyExchange().authenticated())
//                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                .build();
    }
}
