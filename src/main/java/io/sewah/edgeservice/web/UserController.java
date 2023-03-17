package io.sewah.edgeservice.web;

import io.sewah.edgeservice.dto.User;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

//    @GetMapping
//    public Mono<User> getUser() {
//        return ReactiveSecurityContextHolder.getContext()
//         .map(SecurityContext::getAuthentication)
//         .map(authentication ->
//                      (OidcUser) authentication.getPrincipal())
//         .map(oidcUser ->
//                new User(
//                        oidcUser.getPreferredUsername(),
//                        oidcUser.getGivenName(),
//                        oidcUser.getFamilyName(),
//                        List.of("employee", "customer")
//                )
//         );
//
//    }

    @GetMapping
    public Mono<User> getUser(@AuthenticationPrincipal OidcUser oidcUser) {
        return Mono.just(new User(
                oidcUser.getPreferredUsername(),
                oidcUser.getGivenName(),
                oidcUser.getFamilyName(),
//                List.of("employee", "customer")
                oidcUser.getClaimAsStringList("roles")
        ));
    }
}
