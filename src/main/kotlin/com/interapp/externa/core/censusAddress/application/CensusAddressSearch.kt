package com.interapp.externa.core.censusAddress.application

import com.interapp.externa.core.censusAddress.domain.CensusAddress
import com.interapp.externa.core.censusAddress.domain.CensusAddressRepository
import org.springframework.stereotype.Service

@Service
class CensusAddressSearch(private val censusAddressRepository: CensusAddressRepository) {

    fun findCensusAddressByRepresentativeId(id: Long): CensusAddress {
        return censusAddressRepository.findCensusAddressByRepresentativeId(id)
    }

}