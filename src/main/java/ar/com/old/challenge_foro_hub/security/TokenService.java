package ar.com.old.challenge_foro_hub.security;

import ar.com.old.challenge_foro_hub.models.entitites.User;
import io.jsonwebtoken.Claims;
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

    private static final long EXPIRATION_TIME = 3600000;

    public  String generateToken(User user) {
        return Jwts.builder()
                       .setSubject(user.getUserName())
                       .claim("id", user.getId())
                       .setIssuedAt(new Date())
                       .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                       .signWith(convertToHMAC256Format(), SignatureAlgorithm.HS256) // Firmar con HMAC-SHA256
                       .compact();
    }

    public Claims validateToken(String token) {
        return Jwts.parser()
                       .setSigningKey(convertToHMAC256Format())
                       .parseClaimsJws(token)
                       .getBody();
    }

    private   Key convertToHMAC256Format() {
          return  new SecretKeySpec(secretKey.getBytes(),SignatureAlgorithm.HS256.getJcaName()
            );
    }

}
