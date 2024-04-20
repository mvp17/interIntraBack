package com.interapp.externa.core.adoption.domain.repositories

import com.interapp.externa.core.adoption.domain.Adoption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByAdoptionNeighRepo: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a where a.neigh like %?1%")
    fun findAdoptionsByNeigh(neigh: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.neigh like %?1% and a.adoptionDate >= date(?2)")
    fun findAdoptionsByNeighAndAdoptionFromDate(neigh: String, fromDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.neigh like %?1% and a.adoptionDate <= date(?2)")
    fun findAdoptionsByNeighAndAdoptionToDate(neigh: String, toDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.neigh like %?1% and a.adoptionDate >= date(?2) " +
            "and a.adoptionDate <= date(?3)")
    fun findAdoptionsByNeighAndAdoptionFromDateAndAdoptionToDate(
        neigh: String, fromDate: String, toDate: String): MutableList<Adoption>
}
