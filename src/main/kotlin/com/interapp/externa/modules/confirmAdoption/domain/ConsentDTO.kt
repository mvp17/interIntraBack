package com.interapp.externa.modules.confirmAdoption.domain

data class ConsentDTO(
    val registerConsented: Boolean,
    val registerConsentDate: String,
    val authorisationAdult: Boolean,
    val authorisationAdultDate: String,
    val guardian: Boolean,
    val guardianConsentDate: String,
    val visibleForOthers: Boolean,
    val visibleForOthersConsentDate: String,
    val comentario: String,
    val representativeId: Long
)
