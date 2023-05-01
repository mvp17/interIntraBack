package com.interapp.externa.modules.confirmAdoption.domain

data class ConsentDTO(
    val censusConsent: Boolean,
    val censusConsentDate: String,
    val adultAuthorization: Boolean,
    val adultAuthorizationDate: String,
    val guardian: Boolean,
    val guardianConsentDate: String,
    val visibleOthers: Boolean,
    val visibleOthersConsentDate: String?,
    val comment: String,
    val representativeId: Long
)
