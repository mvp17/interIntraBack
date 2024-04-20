package com.interapp.externa.core.godfather.domain.repositories.search

import com.interapp.externa.core.godfather.domain.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByGodfatherNameRepo: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.name like %?1%")
    fun findGodfathersByName(name: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.name like %?1% and g.birthday >= date(?2)")
    fun findGodfathersByNameAndBirthdayFromDate(name: String, fromDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.name like %?1% and g.birthday <= date(?2)")
    fun findGodfathersByNameAndBirthdayToDate(name: String, toDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.name like %?1% and g.birthday >= date(?2) and g.birthday <= date(?3)")
    fun findGodfathersByNameAndBirthdayFromDateAndBirthdayToDate(
        name: String, fromDate: String, toDate: String
    ): MutableList<Godfather>
}
