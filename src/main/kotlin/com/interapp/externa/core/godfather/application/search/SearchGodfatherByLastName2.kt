package com.interapp.externa.core.godfather.application.search

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.GodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByLastName2(private val godfatherRepo: GodfatherRepo) {
    fun findGodfathersByLastName2(lastName2: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByLastName2(lastName2)
    }

    fun findGodfathersByLastName2AndBirthdayFromDate(lastName2: String, fromDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByLastName2AndBirthdayFromDate(lastName2, fromDate)
    }

    fun findGodfathersByLastName2AndBirthdayToDate(lastName2: String, toDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByLastName2AndBirthdayToDate(lastName2, toDate)
    }

    fun findGodfathersByLastName2AndBirthdayFromDateAndBirthdayToDate(
        lastName2: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return godfatherRepo
            .findGodfathersByLastName2AndBirthdayFromDateAndBirthdayToDate(
                lastName2, fromDate, toDate
            )
    }
}
