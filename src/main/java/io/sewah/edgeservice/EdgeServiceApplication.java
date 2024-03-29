package io.sewah.edgeservice;

import java.security.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class EdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeServiceApplication.class, args);
	}

	@Bean
	public KeyResolver keyResolver() {
		return exchange -> exchange.getPrincipal()
				.map(Principal::getName)
				.defaultIfEmpty("anonymous");
	}

}
