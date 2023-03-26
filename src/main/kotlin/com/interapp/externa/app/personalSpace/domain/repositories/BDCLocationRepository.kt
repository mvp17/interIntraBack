package com.interapp.externa.app.personalSpace.domain.repositories

import com.interapp.externa.app.personalSpace.domain.entities.BDCLocation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BDCLocationRepository: JpaRepository<BDCLocation, Long> {
    @Query("select b from BDCLocation b where b.representativeId = ?1")
    fun findBDCLocationByRepresentativeId(id: Long): BDCLocation
}