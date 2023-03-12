package com.interapp.externa.app.login.application

import com.interapp.externa.app.login.domain.AuthenticationRequest
import com.interapp.externa.app.login.domain.AuthenticationResponse
import com.interapp.externa.app.login.domain.RegisterRequest
import com.interapp.externa.config.jwt.JwtService
import com.interapp.externa.config.user.User
import com.interapp.externa.config.user.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
)
{
    fun register(request: RegisterRequest): AuthenticationResponse {
        val user = User(request.username, request.email, passwordEncoder.encode(request.password), 0)
        userRepository.save(user)
        val token = jwtService.generateToken(user.email)
        return AuthenticationResponse(token)
    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse {
        val user = userRepository.findByEmail(request.email).orElseThrow()
        val token = jwtService.generateToken(user.email)
        return AuthenticationResponse(token)
    }
}
