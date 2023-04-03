package com.interapp.externa.core.electoralRollAddress.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ElectoralRollAddressRepository: JpaRepository<ElectoralRollAddress, Long> {
    @Query("select era from ElectoralRollAddress era where era.representativeId = ?1")
    fun findElectoralRollAddressesByRepresentativeId(id: Long): MutableList<ElectoralRollAddress>
}
