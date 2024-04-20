package com.interapp.externa.core.adoption.domain.repositories

import com.interapp.externa.core.adoption.domain.Adoption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface SearchByAdoptionDatesRepo: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a where a.adoptionDate >= date(?1)")
    fun findAdoptionsByFromDate(date: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.adoptionDate <= date(?1)")
    fun findAdoptionsByToDate(date: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.adoptionDate >= date(?1) and a.adoptionDate <= date(?2)")
    fun findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate: String, toDate: String): MutableList<Adoption>
}
