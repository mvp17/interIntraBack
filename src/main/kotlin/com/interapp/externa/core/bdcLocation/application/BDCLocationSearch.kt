package com.interapp.externa.core.bdcLocation.application

import com.interapp.externa.core.bdcLocation.domain.BDCLocation
import com.interapp.externa.core.bdcLocation.domain.BDCLocationRepository
import org.springframework.stereotype.Service

@Service
class BDCLocationSearch(private val bdcLocationRepository: BDCLocationRepository) {
    fun findBDCLocationByRepresentativeId(representativeId: Long): BDCLocation {
        return bdcLocationRepository.findBDCLocationByRepresentativeId(representativeId)
    }
}
