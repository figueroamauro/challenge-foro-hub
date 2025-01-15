package ar.com.old.challenge_foro_hub.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secretKey;



    // Convierte la llave secreta en un formato compatible con HMAC-SHA256
    private   Key getKey() {
          return  new SecretKeySpec(
                    secretKey.getBytes(),
                    SignatureAlgorithm.HS256.getJcaName()
            );
    }


    private static final long EXPIRATION_TIME = 3600000;

    public  String generateToken(String username) {
        return Jwts.builder()
                       .setSubject(username)
                       .setIssuedAt(new Date())
                       .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                       .signWith(getKey(), SignatureAlgorithm.HS256) // Firmar con HMAC-SHA256
                       .compact();
    }
}
