package com.interapp.externa.core.electoralRollAddress.application

import com.interapp.externa.core.electoralRollAddress.domain.ElectoralRollAddress
import com.interapp.externa.core.electoralRollAddress.domain.ElectoralRollAddressRepository
import org.springframework.stereotype.Service

@Service
class ElectoralRollAddressSearch(private val electoralRollAddressRepository: ElectoralRollAddressRepository) {
    fun findPadronAddressesByRepresentativeId(representativeId: Long): MutableList<ElectoralRollAddress> {
        return electoralRollAddressRepository.findElectoralRollAddressesByRepresentativeId(representativeId)
    }
}
