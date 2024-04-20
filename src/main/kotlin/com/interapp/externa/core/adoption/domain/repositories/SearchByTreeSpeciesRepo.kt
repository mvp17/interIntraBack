package com.interapp.externa.core.adoption.domain.repositories

import com.interapp.externa.core.adoption.domain.Adoption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByTreeSpeciesRepo: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.species like %?1%")
    fun findAdoptionsByTreeSpecies(species: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.species like %?1% " +
            "and a.adoptionDate >= date(?2)")
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDate(species: String, date: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.species like %?1% " +
            "and a.adoptionDate <= date(?2)")
    fun findAdoptionsByTreeSpeciesAndAdoptionToDate(species: String, date: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.species like %?1% " +
            "and a.adoptionDate >= date(?2) and a.adoptionDate <= date(?3)")
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
        species: String, fromDate: String, toDate: String
    ): MutableList<Adoption>
}
