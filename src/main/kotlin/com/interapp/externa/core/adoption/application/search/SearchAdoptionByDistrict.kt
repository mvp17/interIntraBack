package com.interapp.externa.core.adoption.application.search

import com.interapp.externa.core.adoption.domain.Adoption
import com.interapp.externa.core.adoption.domain.repositories.SearchByAdoptionRepo
import org.springframework.stereotype.Service

@Service
class SearchAdoptionByDistrict(private val searchByAdoptionRepo: SearchByAdoptionRepo) {
    fun findAdoptionsByDistrict(district: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByDistrict(district)
    }
    fun findAdoptionsByDistrictAndAdoptionFromDate(district: String, fromDate: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByDistrictAndAdoptionFromDate(district, fromDate)
    }
    fun findAdoptionsByDistrictAndAdoptionToDate(district: String, toDate: String): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByDistrictAndAdoptionToDate(district, toDate)
    }
    fun findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
        district: String, fromDate: String, toDate: String
    ): MutableList<Adoption> {
        return searchByAdoptionRepo.findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
            district, fromDate, toDate)
    }
}
