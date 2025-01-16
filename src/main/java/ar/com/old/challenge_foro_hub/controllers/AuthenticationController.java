package ar.com.old.challenge_foro_hub.controllers;

import ar.com.old.challenge_foro_hub.dtos.user.UserRequestDto;
import ar.com.old.challenge_foro_hub.dtos.auth.JWTTokenDto;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import ar.com.old.challenge_foro_hub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<JWTTokenDto> login(@RequestBody UserRequestDto userRequestDto) {
        SecurityContextHolder.clearContext();
        SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
        Authentication token = new UsernamePasswordAuthenticationToken(userRequestDto.userName(), userRequestDto.password());
        Authentication authUser = authenticationManager.authenticate(token);
        User user = (User) authUser.getPrincipal();
        System.out.println(user.getUserName());
        String tokenJWT = tokenService.generateToken(user);
        return ResponseEntity.ok(new JWTTokenDto(tokenJWT));
    }

}
