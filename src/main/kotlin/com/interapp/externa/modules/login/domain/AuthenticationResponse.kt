package com.interapp.externa.modules.login.domain

import java.beans.ConstructorProperties

data class AuthenticationResponse
@ConstructorProperties("token")
constructor(val token: String,
            val userId: Long
)
