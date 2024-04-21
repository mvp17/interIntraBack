package com.interapp.externa.modules.login.application

import com.interapp.externa.modules.login.domain.AuthenticationRequest
import com.interapp.externa.modules.login.domain.AuthenticationResponse
import com.interapp.externa.modules.login.domain.RegisterRequest
import com.interapp.externa.modules.login.application.jwt.JwtService
import com.interapp.externa.core.user.domain.User
import com.interapp.externa.core.user.domain.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

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
        val userId = user.id
        return AuthenticationResponse(token, userId)
    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse {
        val user = userRepository.findByEmail(request.email).orElseThrow()
        val token = jwtService.generateToken(user.email)
        return AuthenticationResponse(token, user.id)
    }

    fun findUserById(id: Long): User {
        return userRepository.findById(id).orElseThrow {
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "User not found!")
        }
    }
}
