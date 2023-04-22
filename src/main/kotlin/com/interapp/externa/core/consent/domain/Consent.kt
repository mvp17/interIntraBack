package com.interapp.externa.core.consent.domain

import jakarta.persistence.*
import java.sql.Date

@Entity
@Table(name = "consents")
data class Consent(
    @Column(name = "census_consent")
    var censusConsent: Boolean,

    @Column(name = "census_consent_date")
    var censusConsentDate: Date,

    @Column(name = "adult_authorization")
    var adultAuthorization: Boolean,

    @Column(name = "adult_authorization_date")
    val adultAuthorizationConsentDate: Date,

    @Column(name = "guardian")
    val guardian: Boolean,

    @Column(name = "guardian_date")
    val guardianConsentDate: Date,

    @Column(name = "visible_others")
    val visibleOthers: Boolean,

    @Column(name = "visible_others_date")
    val visibleOthersConsentDate: Date?,

    @Column(name = "comment")
    val comment: String,

    @Column(name = "representative_id")
    val representativeId: Long,

    @Column(name = "godfather_id")
    val godfatherId: Long,

    @Column(name = "adoption_id")
    val adoptionId: Long,

    @Id
    @SequenceGenerator(
        name = "\"consents_id_seq\"",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "\"consents_id_seq\""
    )
    @Column(name = "id")
    val id: Long
)
