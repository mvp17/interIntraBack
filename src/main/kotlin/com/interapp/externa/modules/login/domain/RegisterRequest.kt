package com.interapp.externa.modules.login.domain

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)
