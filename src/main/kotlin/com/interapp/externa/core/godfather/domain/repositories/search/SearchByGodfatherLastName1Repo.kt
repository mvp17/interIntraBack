package com.interapp.externa.core.godfather.domain.repositories.search

import com.interapp.externa.core.godfather.domain.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByGodfatherLastName1Repo: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.lastName1 like %?1%")
    fun findGodfathersByLastName1(lastName1: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.lastName1 like %?1% and g.birthday >= date(?2)")
    fun findGodfathersByLastName1AndAndBirthdayFromDate(
        lastName1: String, fromDate: String
    ): MutableList<Godfather>

    @Query("select g from Godfather g where g.lastName1 like %?1% and g.birthday <= date(?2)")
    fun findGodfathersByLastName1AndAndBirthdayToDate(
        lastName1: String, toDate: String
    ): MutableList<Godfather>

    @Query("select g from Godfather g where g.lastName1 like %?1% and " +
            "g.birthday >= date(?2) and g.birthday <= date(?2)")
    fun findGodfathersByLastName1AndBirthdayFromDateAndAndBirthdayToDate(
        lastName1: String, fromDate: String, toDate: String
    ): MutableList<Godfather>
}
