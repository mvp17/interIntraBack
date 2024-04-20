package com.interapp.externa.core.godfather.domain.repositories.search

import com.interapp.externa.core.godfather.domain.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByGodfatherGenderRepo: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.gender = ?1")
    fun findGodfathersByGender(gender: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.gender = ?1 and g.birthday >= date(?2)")
    fun findGodfathersByGenderAndBirthdayFromDate(gender: String, fromDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.gender = ?1 and g.birthday <= date(?2)")
    fun findGodfathersByGenderAndBirthdayToDate(gender: String, toDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.gender = ?1 and g.birthday >= date(?2) and g.birthday <= date(?3)")
    fun findGodfathersByGenderAndBirthdayFromDateAndBirthdayToDate(
        gender: String, fromDate: String, toDate: String
    ): MutableList<Godfather>
}
