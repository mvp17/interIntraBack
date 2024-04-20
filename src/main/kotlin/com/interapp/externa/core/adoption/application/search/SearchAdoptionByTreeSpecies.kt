package com.interapp.externa.core.adoption.application.search

import com.interapp.externa.core.adoption.domain.Adoption
import com.interapp.externa.core.adoption.domain.repositories.SearchByAdoptionRepo
import org.springframework.stereotype.Service

@Service
class SearchAdoptionByTreeSpecies(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    fun findAdoptionsByTreeSpecies(treeSpecies: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeSpecies(treeSpecies)
    }
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDate(
        treeSpecies: String, fromDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeSpeciesAndAdoptionFromDate(treeSpecies, fromDate)
    }
    fun findAdoptionsByTreeSpeciesAndAdoptionToDate(
        treeSpecies: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeSpeciesAndAdoptionToDate(treeSpecies, toDate)
    }
    fun findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
        treeSpecies: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
            treeSpecies, fromDate, toDate
        )
    }
}
