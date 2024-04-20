package com.interapp.externa.core.consent.application

import com.interapp.externa.core.consent.domain.Consent
import com.interapp.externa.core.consent.domain.ConsentRepository
import org.springframework.stereotype.Service

@Service
class ConsentSearch(private val consentRepository: ConsentRepository) {
    fun findConsentByRepresentativeId(id: Long): Consent {
        return consentRepository.findConsentByRepresentativeId(id)
    }
    fun findConsentByAdoptionId(adoptionId: Long): Consent {
        return consentRepository.findConsentByAdoptionId(adoptionId)
    }
}
