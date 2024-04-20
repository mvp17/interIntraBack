package com.interapp.externa.core.godfather.domain.repositories.search

import com.interapp.externa.core.godfather.domain.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByGodfatherNeighRepo: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.neigh like %?1%")
    fun findGodfathersByNeigh(neigh: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.neigh like %?1% and g.birthday >= date(?2)")
    fun findGodfathersByNeighAndBirthdayFromDate(neigh: String, fromDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.neigh like %?1% and g.birthday <= date(?2)")
    fun findGodfathersByNeighAndBirthdayToDate(neigh: String, toDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.neigh like %?1% and g.birthday >= date(?2) and g.birthday <= date(?3)")
    fun findGodfathersByNeighAndBirthdayFromDateAndBirthdayToDate(
        neigh: String, fromDate: String, toDate: String
    ): MutableList<Godfather>
}
