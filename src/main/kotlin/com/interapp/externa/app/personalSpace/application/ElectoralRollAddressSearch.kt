package com.interapp.externa.app.personalSpace.application

import com.interapp.externa.app.personalSpace.domain.entities.ElectoralRollAddress
import com.interapp.externa.app.personalSpace.domain.repositories.ElectoralRollAddressRepository
import org.springframework.stereotype.Service

@Service
class ElectoralRollAddressSearch(private val electoralRollAddressRepository: ElectoralRollAddressRepository) {
    fun findPadronAddressesByRepresentativeId(representativeId: Long): MutableList<ElectoralRollAddress> {
        return electoralRollAddressRepository.findElectoralRollAddressesByRepresentativeId(representativeId)
    }
}
