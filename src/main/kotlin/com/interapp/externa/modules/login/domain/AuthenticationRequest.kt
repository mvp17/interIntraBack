package com.interapp.externa.modules.login.domain

import java.beans.ConstructorProperties

data class AuthenticationRequest
@ConstructorProperties("email", "password")
constructor(val email: String, val password: String)
