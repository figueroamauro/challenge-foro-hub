package ar.com.old.challenge_foro_hub.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    LoginFilter loginFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("spring filter");
        return http.csrf(AbstractHttpConfigurer::disable)
                       .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                       .authorizeHttpRequests(req -> {
                           req.requestMatchers(HttpMethod.POST, "/login").permitAll();
                           req.requestMatchers(HttpMethod.POST, "/users").permitAll();
                           req.requestMatchers(HttpMethod.GET, "/**").permitAll();
                           req.anyRequest().authenticated();
                       })
                       .exceptionHandling(ex -> ex.authenticationEntryPoint((request, response, authException) -> {
                           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                           response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                       }))
                      .addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class)
                       .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
