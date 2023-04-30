package com.interapp.externa.core.consent.application

import com.interapp.externa.core.consent.domain.Consent
import com.interapp.externa.core.consent.domain.ConsentRepository
import org.springframework.stereotype.Service

@Service
class ConsentService(private val consentRepository: ConsentRepository) {
    fun addConsent(consent: Consent): Consent {
        return consentRepository.save(consent)
    }

    fun findConsentByAdoptionId(adoptionId: Long): Consent {
        return consentRepository.findConsentByAdoptionId(adoptionId)
    }
    fun deleteConsent(consent: Consent) {
        consentRepository.delete(consent)
    }
}
