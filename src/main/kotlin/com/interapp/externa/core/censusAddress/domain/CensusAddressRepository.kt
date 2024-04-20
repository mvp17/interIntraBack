package com.interapp.externa.core.censusAddress.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CensusAddressRepository: JpaRepository<CensusAddress, Long> {

    @Query("select c from CensusAddress c where c.representativeId = ?1")
    fun findCensusAddressByRepresentativeId(id: Long): CensusAddress

}
