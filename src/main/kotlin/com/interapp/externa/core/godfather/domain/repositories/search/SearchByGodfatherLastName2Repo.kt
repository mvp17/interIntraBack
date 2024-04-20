package com.interapp.externa.core.godfather.domain.repositories.search

import com.interapp.externa.core.godfather.domain.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByGodfatherLastName2Repo: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.lastName2 like %?1%")
    fun findGodfathersByLastName2(lastName2: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.lastName2 like %?1% and g.birthday >= date(?2)")
    fun findGodfathersByLastName2AndBirthdayFromDate(
        lastName2: String, fromDate: String
    ): MutableList<Godfather>

    @Query("select g from Godfather g where g.lastName2 like %?1% and g.birthday <= date(?2)")
    fun findGodfathersByLastName2AndBirthdayToDate(
        lastName2: String, toDate: String
    ): MutableList<Godfather>

    @Query("select g from Godfather g where g.lastName2 like %?1% and " +
            "g.birthday >= date(?2) and g.birthday <= date(?2)")
    fun findGodfathersByLastName2AndBirthdayFromDateAndBirthdayToDate(
        lastName2: String, fromDate: String, toDate: String
    ): MutableList<Godfather>
}
