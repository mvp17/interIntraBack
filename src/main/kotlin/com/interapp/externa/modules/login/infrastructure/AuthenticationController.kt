package com.interapp.externa.modules.login.infrastructure

import com.interapp.externa.core.user.domain.User
import com.interapp.externa.modules.login.application.AuthService
import com.interapp.externa.modules.login.domain.AuthenticationRequest
import com.interapp.externa.modules.login.domain.AuthenticationResponse
import com.interapp.externa.modules.login.domain.RegisterRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/auth")
class AuthenticationController(private val authService: AuthService) {
    @PostMapping("/register")
    fun register(@RequestBody user: RegisterRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authService.register(user))
    }

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authService.authenticate(request))
    }

    @GetMapping("/users/{id}")
    fun findUser(@PathVariable id: Long): User {
        return authService.findUserById(id)
    }
}
