package com.interapp.externa.modules.myAdoptions.domain

data class RevokeDTO(
    val adoptionId: Long,
    val representativeId: Long,
    val godfatherId: Long,
    val visibleOthersConsentRevocationDate: String
)
