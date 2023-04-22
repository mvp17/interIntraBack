package com.interapp.externa.modules.confirmAdoption.domain

import java.sql.Date

data class ConsentDTO(
    val censusConsent: Boolean,
    val censusConsentDate: Date,
    val adultAuthorization: Boolean,
    val adultAuthorizationDate: Date,
    val guardian: Boolean,
    val guardianConsentDate: Date,
    val visibleOthers: Boolean,
    val visibleOthersConsentDate: Date?,
    val comment: String,
    val representativeId: Long
)
