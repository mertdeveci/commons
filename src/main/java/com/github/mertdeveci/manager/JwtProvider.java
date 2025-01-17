package com.github.mertdeveci.manager;

import com.github.mertdeveci.utils.DateUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/*
{
  "iss": "example.com",           // Yayıncı (issuer)
  "sub": "1234567890",             // Konu (subject)
  "aud": "myapp",                  // Hedef Kitle (audience)
  "exp": 1616235023,               // Son Kullanma Zamanı (expiration)
  "nbf": 1616235023,               // Geçerli Olma Başlangıcı (not before)
  "iat": 1616235023,               // Veriliş Zamanı (issued at)
  "jti": "abc123"                  // Token Kimliği (JWT ID)
}

 */
public abstract class JwtProvider {
    private final String SECRET_KEY; // HMAC algoritması için kullanılacak anahtar
    private final long EXPIRATION_TIME; // Anahtarın geçerlilik süresi (Mikrosaniye)

    public JwtProvider(String secretKey, long expirationTime) {
        this.SECRET_KEY = secretKey;
        this.EXPIRATION_TIME = expirationTime;
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * HMAC (HS256) ile JWT oluşturma
     */
    public String createJWT(Map<String, Object> claims) {
        return Jwts.builder()
                .claims(claims)
                .issuedAt(DateUtils.now())
                .expiration(new Date(DateUtils.now().getTime() + EXPIRATION_TIME))
                .signWith(getSecretKey())
                .compact();
    }

    /**
     * JWT doğrulama (HMAC ile)
     */
    public boolean isJwtValid(String jwt) {
        try {
            Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(jwt);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false; // Token geçersiz veya imza doğrulaması başarısız
        }
    }

    /**
     * JWT içerisindeki claim'leri okuma
     */
    public Claims getClaims(String jwt) {
        try {
            return Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(jwt)
                    .getPayload();
        } catch (JwtException e) {
            return null; // Token geçersizse null döner
        }
    }

    /**
     * JWT'nin süresinin dolup dolmadığını kontrol etme
     */
    public boolean isExpired(String jwt) {
        Claims claims = getClaims(jwt);
        return Objects.nonNull(claims) && claims.getExpiration().before(new Date());
    }

    /**
     * JWT'den kullanıcı bilgilerini alma
     */
    public String getSubject(String jwt) {
        Claims claims = getClaims(jwt);
        return Objects.nonNull(claims) ? claims.getSubject() : null;
    }

    /**
     * JWT'den claim bilgisi alma
     */
    public Object getClaimValue(String jwt, String claimName) {
        Claims claims = getClaims(jwt);
        return Objects.nonNull(claims) ? claims.get(claimName) : null;
    }

    /**
     * JWT token'dan alınan kullanıcı bilgisi ve ek claim'leri kullanarak yeni JWT oluşturma
     */
    public String refreshJWT(String jwt) {
        Claims claims = getClaims(jwt);
        if (Objects.nonNull(claims)) {
            return createJWT(claims);
        }
        return null;
    }

}
