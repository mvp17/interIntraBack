package com.interapp.externa.core.adoption.application

import com.interapp.externa.core.adoption.domain.Adoption
import com.interapp.externa.core.adoption.domain.AdoptionRepository
import org.springframework.stereotype.Service

@Service
class AdoptionSearch(private val adoptionRepository: AdoptionRepository) {
    fun findAdoptionsByRepresentativeId(representativeId: Long): MutableList<Adoption> {
        return adoptionRepository.findAdoptionsByRepresentativeId(representativeId)
    }

    fun findAdoptionById(id: Long): Adoption {
        return adoptionRepository.findById(id).orElseThrow()
    }
}
