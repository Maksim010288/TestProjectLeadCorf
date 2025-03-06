package com.baziuk.KeyCloackTestProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class KeyCloakTestSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http
                .authorizeHttpRequests(c -> c.requestMatchers("error").permitAll()
                        .requestMatchers("/get").hasRole("ADMIN")
                        .requestMatchers("/getAll").hasRole("USER")
                        .requestMatchers(("/getAllInfo")).hasRole("MANAGER")
                        .requestMatchers("/getPost").permitAll()
                        .anyRequest().authenticated())
                .build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthoritiesConverter() {
        var converter = new JwtAuthenticationConverter();
        var jwtGrandAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        converter.setPrincipalClaimName("preferred_username");
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            var authorities = jwtGrandAuthoritiesConverter.convert(jwt);
            var roles = jwt.getClaimAsStringList("myapp_sec_roles");
            for (String txt: roles){
                System.err.println(txt);
            }
            return Stream.concat(authorities.stream(), roles.stream()
                    .filter(role -> role.startsWith("ROLE_"))
                    .map(SimpleGrantedAuthority::new)
                    .map(GrantedAuthority.class::cast)).collect(Collectors.toList());
        });

        return converter;
    }


}
