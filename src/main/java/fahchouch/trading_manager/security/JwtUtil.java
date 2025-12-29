package fahchouch.trading_manager.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String genToken(String userId, long expMillis) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expMillis))
                .signWith(secretKey)
                .compact();
    }

    public static String genToken(String userId) {
        long oneDayMillis = 24 * 60 * 60 * 1000;
        return genToken(userId, oneDayMillis);
    }

    public static String validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
