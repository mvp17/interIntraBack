package com.interapp.externa.core.adoption.application.search

import com.interapp.externa.core.adoption.domain.Adoption
import com.interapp.externa.core.adoption.domain.repositories.SearchByAdoptionRepo
import org.springframework.stereotype.Service

@Service
class SearchAdoptionByDates(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    fun findAdoptionsByAdoptionFromDate(date: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByFromDate(date)
    }
    fun findAdoptionsByAdoptionToDate(date: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByToDate(date)
    }
    fun findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate: String, toDate: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByAdoptionFromDateAndAdoptionToDate(fromDate, toDate)
    }
}
