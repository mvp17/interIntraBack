package com.interapp.externa.core.godfather.application.search

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.search.SearchByGodfatherNeighRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByNeigh(private val searchByGodfatherNeighRepo: SearchByGodfatherNeighRepo) {
    fun findGodfathersByNeigh(neigh: String): MutableList<Godfather> {
        return searchByGodfatherNeighRepo.findGodfathersByNeigh(neigh)
    }
    fun findGodfathersByNeighAndBirthdayFromDate(neigh: String, fromDate: String): MutableList<Godfather> {
        return searchByGodfatherNeighRepo.findGodfathersByNeighAndBirthdayFromDate(neigh, fromDate)
    }

    fun findGodfathersByNeighAndBirthdayToDate(neigh: String, toDate: String): MutableList<Godfather> {
        return searchByGodfatherNeighRepo.findGodfathersByNeighAndBirthdayToDate(neigh, toDate)
    }

    fun findGodfathersByNeighAndBirthdayFromDateAndBirthdayToDate(
        neigh: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return searchByGodfatherNeighRepo
            .findGodfathersByNeighAndBirthdayFromDateAndBirthdayToDate(
                neigh, fromDate, toDate
            )
    }
}
