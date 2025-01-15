package ar.com.old.challenge_foro_hub.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    private static final String SECRET_KEY = "123123123123123123123123123123123";

    // Convierte la llave secreta en un formato compatible con HMAC-SHA256
    private static final Key HMAC_KEY = new SecretKeySpec(
            SECRET_KEY.getBytes(),
            SignatureAlgorithm.HS256.getJcaName()
    );

    private static final long EXPIRATION_TIME = 3600000;

    public static String generateToken(String username) {
        return Jwts.builder()
                       .setSubject(username)
                       .setIssuedAt(new Date())
                       .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                       .signWith(HMAC_KEY, SignatureAlgorithm.HS256) // Firmar con HMAC-SHA256
                       .compact();
    }
}
