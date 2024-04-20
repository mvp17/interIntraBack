package com.interapp.externa.core.godfather.application.search

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.GodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByBirthdayDates(private val godfatherRepo: GodfatherRepo) {
    fun findGodfathersByBirthdayFromDate(date: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByBirthdayFromDate(date)
    }

    fun findGodfathersByBirthdayToDate(date: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByBirthdayToDate(date)
    }

    fun findGodfathersByBirthdayFromDateAndBirthdayToDate(fromDate: String, toDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByBirthdayFromDateAndBirthdayToDate(fromDate, toDate)
    }
}
