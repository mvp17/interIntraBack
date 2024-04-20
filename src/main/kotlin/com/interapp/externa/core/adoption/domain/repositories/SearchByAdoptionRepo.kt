package com.interapp.externa.core.adoption.domain.repositories

import com.interapp.externa.core.adoption.domain.Adoption
import com.interapp.externa.core.adoption.domain.repositories.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SearchByAdoptionRepo:
    JpaRepository<Adoption, Long>,
    SearchByAdoptionDatesRepo,
    SearchByAdoptionDistrictRepo,
    SearchByAdoptionNeighRepo,
    SearchByTreeNameRepo,
    SearchByTreeSpeciesRepo
{
    @Query("select a from Adoption a where a.godfatherId = ?1")
    fun findAdoptionsByGodfatherId(id: Long): MutableList<Adoption>

    @Query("select a from Adoption a where a.representativeId = ?1")
    fun findAdoptionsByRepresentativeId(id: Long): MutableList<Adoption>
}
