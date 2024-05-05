package com.interapp.externa.core.adoption.application.search

import com.interapp.externa.core.adoption.domain.Adoption
import com.interapp.externa.core.adoption.domain.repositories.SearchByAdoptionRepo
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat

@Service
class SearchAdoptionByDates(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    private val inputFormat = SimpleDateFormat("dd-MM-yyyy")
    private val outputFormat = SimpleDateFormat("yyyy-MM-dd")
    fun findAdoptionsByAdoptionFromDate(date: String): MutableList<Adoption> {
        val parsedDate = inputFormat.parse(date)
        val outputDateString = outputFormat.format(parsedDate)

        return searchByAdoptionRepo.findAdoptionsByFromDate(outputDateString)
    }
    fun findAdoptionsByAdoptionToDate(date: String): MutableList<Adoption> {
        val parsedDate = inputFormat.parse(date)
        val outputDateString = outputFormat.format(parsedDate)

        return searchByAdoptionRepo.findAdoptionsByToDate(outputDateString)
    }
    fun findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate: String, toDate: String): MutableList<Adoption> {
        val parsedFromDate = inputFormat.parse(fromDate)
        val outputFromDateString = outputFormat.format(parsedFromDate)
        val parsedToDate = inputFormat.parse(toDate)
        val outputToDateString = outputFormat.format(parsedToDate)

        return searchByAdoptionRepo.findAdoptionsByAdoptionFromDateAndAdoptionToDate(outputFromDateString, outputToDateString)
    }
}
