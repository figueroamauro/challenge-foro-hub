package ar.com.old.challenge_foro_hub.controllers;

import ar.com.old.challenge_foro_hub.dtos.user.UserRequestDto;
import ar.com.old.challenge_foro_hub.dtos.auth.JWTTokenDto;
import ar.com.old.challenge_foro_hub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTTokenDto> login(@RequestBody UserRequestDto userRequestDto) {
        Authentication token = new UsernamePasswordAuthenticationToken(userRequestDto.userName(), userRequestDto.password());
        Authentication authUser = authenticationManager.authenticate(token);
        String tokenJWT = tokenService.generateToken(authUser.getName());
        return ResponseEntity.ok(new JWTTokenDto(tokenJWT));
    }
}
