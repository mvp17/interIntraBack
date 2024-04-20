package com.interapp.externa.core.godfather.application.search

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.GodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByGender(private val godfatherRepo: GodfatherRepo) {
    fun findGodfathersByGender(gender: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByGender(gender)
    }

    fun findGodfathersByGenderAndBirthdayFromDate(gender: String, fromDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByGenderAndBirthdayFromDate(gender, fromDate)
    }

    fun findGodfathersByGenderAndBirthdayToDate(gender: String, toDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByGenderAndBirthdayToDate(gender, toDate)
    }

    fun findGodfathersByGenderAndBirthdayFromDateAndBirthdayToDate(
        gender: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return godfatherRepo
            .findGodfathersByGenderAndBirthdayFromDateAndBirthdayToDate(
                gender, fromDate, toDate
            )
    }
}
