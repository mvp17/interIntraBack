package com.interapp.externa.app.personalSpace.application

import com.interapp.externa.app.personalSpace.domain.entities.Godfather
import com.interapp.externa.app.personalSpace.domain.repositories.GodfatherRepository
import org.springframework.stereotype.Service

@Service
class GodfatherSearch(
    private val godfatherRepository: GodfatherRepository,
    private val electoralRollAddressSearch: ElectoralRollAddressSearch
) {
    fun findGodfathersByRepresentativeId(id: Long): MutableList<Godfather> {
        val godfathers = mutableListOf<Godfather>()
        val electoralRollAddresses = electoralRollAddressSearch.findPadronAddressesByRepresentativeId(id)
        for (electoralRollAddress in electoralRollAddresses) {
            val godfather = godfatherRepository.findById(electoralRollAddress.godfatherId).orElseThrow()
            godfathers.add(godfather)
        }
        return godfathers
    }
}
