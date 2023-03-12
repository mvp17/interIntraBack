package com.interapp.externa.config.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.util.Date


@Service
class JwtService {
    private val secret = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970"
    private val expiration = 1000 * 60 * 24

    fun generateToken(username: String): String =
        Jwts.builder()
            .setSubject(username)
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS256, secret.toByteArray())
            .compact()

    private fun getClaims(token: String) =
        Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(token).body

    fun getEmail(token: String): String = getClaims(token).subject

    fun isTokenValid(token: String): Boolean {
        val claims = getClaims(token)
        val expirationDate = claims.expiration
        val now = Date(System.currentTimeMillis())
        return now.before(expirationDate)
    }
}
