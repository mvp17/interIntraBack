package com.interapp.externa.modules.confirmAdoption.domain

import java.sql.Date

data class GodfatherDTO(
    val name: String,
    val lastName1: String,
    val lastName2: String,
    val gender: String,
    val birthday: Date
)
