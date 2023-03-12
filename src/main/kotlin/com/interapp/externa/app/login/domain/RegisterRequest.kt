package com.interapp.externa.app.login.domain

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)
