package com.interapp.externa.core.adoption.domain.repositories

import com.interapp.externa.core.adoption.domain.Adoption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByTreeNameRepo: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.commonName like %?1%")
    fun findAdoptionsByTreeName(name: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and " +
            "t.commonName like %?1% and a.adoptionDate >= date(?2)")
    fun findAdoptionsByTreeNameAndAdoptionFromDate(name: String, date: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.commonName like %?1% " +
            "and a.adoptionDate <= date(?2)")
    fun findAdoptionsByTreeNameAndAdoptionToDate(name: String, date: String): MutableList<Adoption>

    @Query("select a from Adoption a, Tree t where a.treeId = t.id and t.commonName like %?1% " +
            "and a.adoptionDate >= date(?2) and a.adoptionDate <= date(?3)")
    fun findAdoptionsByTreeNameAndAdoptionFromDateAndAdoptionToDate(
        name: String, fromDate: String, toDate: String
    ): MutableList<Adoption>
}
