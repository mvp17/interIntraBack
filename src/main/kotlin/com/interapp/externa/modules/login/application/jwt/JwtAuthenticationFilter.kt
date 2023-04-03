package com.interapp.externa.modules.login.application.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import com.interapp.externa.modules.login.domain.AuthenticationRequest
import com.interapp.externa.core.user.domain.UserSecurity
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*


class JwtAuthenticationFilter(
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) :
    UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(
        req: HttpServletRequest,
        response: HttpServletResponse)
    : Authentication {
        val credentials = ObjectMapper().readValue(
            req.inputStream,
            AuthenticationRequest::class.java)
        val auth = UsernamePasswordAuthenticationToken(
            credentials.email,
            credentials.password,
            Collections.singleton(SimpleGrantedAuthority("user"))
        )
        return authenticationManager.authenticate(auth)
    }

    override fun successfulAuthentication(
        req: HttpServletRequest?, res: HttpServletResponse, chain: FilterChain?,
        auth: Authentication
    ) {
        val username = (auth.principal as UserSecurity).username
        val token: String = jwtService.generateToken(username)
        res.addHeader("Authorization", token)
        res.addHeader("Access-Control-Expose-Headers", "Authorization")
    }

    override fun unsuccessfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        failed: AuthenticationException
    ) {
        val error = BadCredentialsError()
        response.status = error.status
        response.contentType = "application/json"
        response.writer.append(error.toString())
    }

}
private data class BadCredentialsError(
    val timestamp: Long = Date().time,
    val status: Int = 401,
    val message: String = "Email or password incorrect",
) {
    override fun toString(): String {
        return ObjectMapper().writeValueAsString(this)
    }
}
