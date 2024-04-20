package com.interapp.externa.core.godfather.application.search

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.GodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByLastName1(private val godfatherRepo: GodfatherRepo) {
    fun findGodfathersByLastName1(lastName1: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByLastName1(lastName1)
    }
    fun findGodfathersByLastName1AndBirthdayFromDate(lastName1: String, fromDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByLastName1AndAndBirthdayFromDate(lastName1, fromDate)
    }
    fun findGodfathersByLastName1AndBirthdayToDate(lastName1: String, toDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByLastName1AndAndBirthdayToDate(lastName1, toDate)
    }
    fun findGodfathersByLastName1AndBirthdayFromDateAndBirthdayToDate(
        lastName1: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return godfatherRepo
            .findGodfathersByLastName1AndBirthdayFromDateAndAndBirthdayToDate(
                lastName1, fromDate, toDate
            )
    }
}
