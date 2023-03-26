package com.interapp.externa.app.myAdoptions.application

import com.interapp.externa.app.myAdoptions.domain.Adoption
import com.interapp.externa.app.myAdoptions.domain.AdoptionRepository
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
