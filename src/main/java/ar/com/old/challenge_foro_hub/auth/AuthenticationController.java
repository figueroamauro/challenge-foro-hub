package ar.com.old.challenge_foro_hub.auth;

import ar.com.old.challenge_foro_hub.dtos.user.UserRequestDto;
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

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserRequestDto userRequestDto) {
        Authentication token = new UsernamePasswordAuthenticationToken(userRequestDto.userName(), userRequestDto.password());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok("Login successful");
    }
}
