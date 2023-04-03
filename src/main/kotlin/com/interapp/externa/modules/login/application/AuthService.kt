package com.interapp.externa.modules.login.application

import com.interapp.externa.modules.login.domain.AuthenticationRequest
import com.interapp.externa.modules.login.domain.AuthenticationResponse
import com.interapp.externa.modules.login.domain.RegisterRequest
import com.interapp.externa.modules.login.application.jwt.JwtService
import com.interapp.externa.core.user.domain.User
import com.interapp.externa.core.user.domain.UserRepository
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
