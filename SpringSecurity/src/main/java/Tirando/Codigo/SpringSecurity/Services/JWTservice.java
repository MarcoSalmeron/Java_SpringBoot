package Tirando.Codigo.SpringSecurity.Services;

import Tirando.Codigo.SpringSecurity.Models.User;
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
public class JWTservice {


    //Crear JWT//

    //Firma Secreta//
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    //retornar token de usuario//
    public String getToken(User user){
        return getToken(new HashMap<>(), user);
    }

    //personalizar claims,subject,emision,expiracion,firma//
    private String getToken(Map<String,Object> extraClaims, User user){
        return Jwts
                .builder()
                .claim("Nombre",user.getFirst_name())
                .claim("Email", user.getEmail())
                .claims(extraClaims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*24*60))
                .signWith(getKey())
                .compact();
    }

    //Firma secreta//
    private SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //extraer los Claims//
    private Claims getAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    //buscar Claim//
    public <T> T getClaim(String token, Function<Claims,T> claimsResolver){
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

        return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
