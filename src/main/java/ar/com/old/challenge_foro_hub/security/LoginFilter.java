package ar.com.old.challenge_foro_hub.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class LoginFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (!isEmptyToken(token)) {
            try {
                token = formatToken(token);
                Claims claims = tokenService.validateToken(token);
                if (claims.getSubject() != null) {
                    setAuthentication(claims);
                }
            }catch (Exception e) {
                SecurityContextHolder.clearContext();
            }

        }

        filterChain.doFilter(request, response);

    }

    private void setAuthentication(Claims claims) {
        String username = claims.getSubject();
        List<GrantedAuthority> authorities = List.of(); // Agrega roles si es necesario
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private static String formatToken(String token) {
        return token.replace("Bearer ", "");
    }

    private static boolean isEmptyToken(String token) {
        return token == null || token.isEmpty();
    }
}
