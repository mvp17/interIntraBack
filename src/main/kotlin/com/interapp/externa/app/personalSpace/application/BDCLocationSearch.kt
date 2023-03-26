package com.interapp.externa.app.personalSpace.application

import com.interapp.externa.app.personalSpace.domain.entities.BDCLocation
import com.interapp.externa.app.personalSpace.domain.repositories.BDCLocationRepository
import org.springframework.stereotype.Service

@Service
class BDCLocationSearch(private val bdcLocationRepository: BDCLocationRepository) {
    fun findBDCLocationByRepresentativeId(representativeId: Long): BDCLocation {
        return bdcLocationRepository.findBDCLocationByRepresentativeId(representativeId)
    }
}
