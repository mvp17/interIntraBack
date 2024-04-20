package com.interapp.externa.core.adoption.application.search

import com.interapp.externa.core.adoption.domain.Adoption
import com.interapp.externa.core.adoption.domain.repositories.SearchByAdoptionRepo
import org.springframework.stereotype.Service

@Service
class SearchAdoptionByNeigh(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    fun findAdoptionsByNeigh(neigh: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByNeigh(neigh)
    }
    fun findAdoptionsByNeighAndAdoptionFromDate(neigh: String, fromDate: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByNeighAndAdoptionFromDate(neigh, fromDate)
    }
    fun findAdoptionsByNeighAndAdoptionToDate(neigh: String, toDate: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByNeighAndAdoptionToDate(neigh, toDate)
    }
    fun findAdoptionsByNeighAndAdoptionFromDateAndAdoptionToDate(
        neigh: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByNeighAndAdoptionFromDateAndAdoptionToDate(neigh, fromDate, toDate)
    }
}
