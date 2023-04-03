package com.interapp.externa.core.adoption.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AdoptionRepository: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a where a.representativeId = ?1")
    fun findAdoptionsByRepresentativeId(id: Long): MutableList<Adoption>
}