package com.interapp.externa.modules.confirmAdoption.domain

import java.sql.Date

data class AdoptionDTO(
    val adoptionDate: Date,
    val godfatherDistance: Float
)
