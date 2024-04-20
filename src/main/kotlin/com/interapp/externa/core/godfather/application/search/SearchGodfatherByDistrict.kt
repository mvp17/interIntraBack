package com.interapp.externa.core.godfather.application.search

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.GodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByDistrict(private val godfatherRepo: GodfatherRepo) {
    fun findGodfathersByDistrict(district: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByDistrict(district)
    }

    fun findGodfathersByDistrictAndBirthdayFromDate(district: String, fromDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByDistrictAndBirthdayFromDate(district, fromDate)
    }

    fun findGodfathersByDistrictAndBirthdayToDate(district: String, toDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByDistrictAndBirthdayToDate(district, toDate)
    }

    fun findGodfathersByDistrictAndBirthdayFromDateAndBirthdayToDate(
        district: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return godfatherRepo
            .findGodfathersByDistrictAndBirthdayFromDateAndBirthdayToDate(
                district, fromDate, toDate
            )
    }
}
