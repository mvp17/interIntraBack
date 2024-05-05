package com.interapp.externa.core.godfather.application.search

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.GodfatherRepo
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat

@Service
class SearchGodfatherByBirthdayDates(private val godfatherRepo: GodfatherRepo) {
    private val inputFormat = SimpleDateFormat("dd-MM-yyyy")
    private val outputFormat = SimpleDateFormat("yyyy-MM-dd")
    fun findGodfathersByBirthdayFromDate(date: String): MutableList<Godfather> {
        val parsedDate = inputFormat.parse(date)
        val outputDateString = outputFormat.format(parsedDate)

        return godfatherRepo.findGodfathersByBirthdayFromDate(outputDateString)
    }

    fun findGodfathersByBirthdayToDate(date: String): MutableList<Godfather> {
        val parsedDate = inputFormat.parse(date)
        val outputDateString = outputFormat.format(parsedDate)

        return godfatherRepo.findGodfathersByBirthdayToDate(outputDateString)
    }

    fun findGodfathersByBirthdayFromDateAndBirthdayToDate(fromDate: String, toDate: String): MutableList<Godfather> {
        val parsedFromDate = inputFormat.parse(fromDate)
        val outputFromDateString = outputFormat.format(parsedFromDate)
        val parsedToDate = inputFormat.parse(toDate)
        val outputToDateString = outputFormat.format(parsedToDate)

        return godfatherRepo.findGodfathersByBirthdayFromDateAndBirthdayToDate(outputFromDateString, outputToDateString)
    }
}
