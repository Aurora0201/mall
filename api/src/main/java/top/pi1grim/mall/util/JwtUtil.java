package top.pi1grim.mall.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import top.pi1grim.mall.entity.Users;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    public static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String getToken(Users user) {
        if(user == null) return null;
        return Jwts.builder()
                .signWith(KEY)
                .setId(String.valueOf(user.getUserId()))
                .setIssuer("Bin")
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .setSubject("Login")
                .claim("username", user.getUsername())
                .compact();
    }

}
