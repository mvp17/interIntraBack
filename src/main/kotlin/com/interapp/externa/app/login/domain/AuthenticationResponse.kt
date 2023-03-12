package com.interapp.externa.app.login.domain

import java.beans.ConstructorProperties

data class AuthenticationResponse
@ConstructorProperties("token")
constructor(val token: String)
