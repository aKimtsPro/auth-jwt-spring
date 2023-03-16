package be.technifutur.bartholomiche.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import be.technifutur.bartholomiche.JWT.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter filter) throws Exception {

        http.csrf().disable();
        http.httpBasic().disable();
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests( (authorize) -> {
            authorize
                    .requestMatchers("/user/add").anonymous()
                    .requestMatchers("/user/sign_in").anonymous()
                    .requestMatchers("/sandwich/*").anonymous()
                    .requestMatchers("/panier/*").authenticated()
                    .requestMatchers("/shipping/*").authenticated()
                    .requestMatchers("/plane{id:[0-9]+}/patch").hasAuthority("ROLE_ADMIN")
                    .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/plane/{id:[0-9]+}").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                    .anyRequest().permitAll();
        });

        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
