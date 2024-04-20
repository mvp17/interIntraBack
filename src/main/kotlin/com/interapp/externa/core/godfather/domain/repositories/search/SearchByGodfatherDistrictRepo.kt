package com.interapp.externa.core.godfather.domain.repositories.search

import com.interapp.externa.core.godfather.domain.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByGodfatherDistrictRepo: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.district like %?1%")
    fun findGodfathersByDistrict(district: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.district like %?1% and g.birthday >= date(?2)")
    fun findGodfathersByDistrictAndBirthdayFromDate(district: String, fromDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.district like %?1% and g.birthday <= date(?2)")
    fun findGodfathersByDistrictAndBirthdayToDate(district: String, toDate: String): MutableList<Godfather>

    @Query("select g from Godfather g where g.district like %?1% and " +
            "g.birthday >= date(?2) and g.birthday <= date(?2)")
    fun findGodfathersByDistrictAndBirthdayFromDateAndBirthdayToDate(
        district: String, fromDate: String, toDate: String
    ): MutableList<Godfather>
}
