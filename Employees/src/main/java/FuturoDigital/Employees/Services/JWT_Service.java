package FuturoDigital.Employees.Services;

import FuturoDigital.Employees.Models.Employees;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWT_Service {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String getToken(Employees employees){
        return getToken(new HashMap<>(), employees);
    }

    private String getToken(Map<String, Object> claims, UserDetails userDetails){
        return Jwts.builder()
                .signWith(getKey())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*24))
                .subject(userDetails.getUsername())
                .claims(claims)
                .compact();
    }

    private SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims getAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T getClaim (String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token){
        return getClaim(token,Claims::getExpiration);
    }

    public boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }

    public String getUserFromToken(String token){
        return getClaim(token,Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = getUserFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
