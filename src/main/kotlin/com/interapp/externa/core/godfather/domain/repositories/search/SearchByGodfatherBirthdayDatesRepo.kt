package com.interapp.externa.core.godfather.domain.repositories.search

import com.interapp.externa.core.godfather.domain.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByGodfatherBirthdayDatesRepo: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.birthday >= date(?1)")
    fun findGodfathersByBirthdayFromDate(date: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.birthday <= date(?1)")
    fun findGodfathersByBirthdayToDate(date: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.birthday >= date(?1) and g.birthday <= date(?2)")
    fun findGodfathersByBirthdayFromDateAndBirthdayToDate(fromDate: String, toDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.name = ?1 and g.birthday = date(?2)")
    fun findGodfatherByNameAndBirthday(name: String, birthday: String): Godfather?
}
