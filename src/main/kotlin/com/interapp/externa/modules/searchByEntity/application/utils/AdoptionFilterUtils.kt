package com.interapp.externa.modules.searchByEntity.application.utils

import com.interapp.externa.modules.searchByEntity.application.SearchByAdoption
import com.interapp.externa.modules.searchByEntity.domain.FilterJSONAdoptionDTO
import com.interapp.externa.core.adoption.domain.Adoption
import org.springframework.stereotype.Service

@Service
class AdoptionFilterUtils(val searchByAdoption: SearchByAdoption) {
    fun filterWhenNoDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>): List<Adoption> {
        if (filter.hasTreeName())
            adoptions.addAll(searchByAdoption.searchAdoptionByTreeName
                .findAdoptionsByTreeName(
                    filter.treeName!!
                )
            )
        if (filter.hasTreeSpecies())
            adoptions.addAll(searchByAdoption.searchAdoptionByTreeSpecies
                .findAdoptionsByTreeSpecies(
                    filter.treeSpecies!!
                )
            )
        if (filter.hasAdoptionDistrict())
            adoptions.addAll(searchByAdoption.searchAdoptionByDistrict
                .findAdoptionsByDistrict(
                    filter.adoptionDistrict!!
                )
            )
        if (filter.hasAdoptionNeigh())
            adoptions.addAll(searchByAdoption.searchAdoptionByNeigh
                .findAdoptionsByNeigh(
                    filter.adoptionNeigh!!
                )
            )
        return adoptions.distinct()
    }
    fun filterWhenTreeNameAndDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>) {
        // treeName + adoptionFromDate
        if (filter.hasTreeName()            and
            filter.hasAdoptionFromDate()    and
            !filter.hasAdoptionToDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByTreeName
                .findAdoptionsByTreeNameAndAdoptionFromDate(
                    filter.treeName!!,
                    filter.adoptionFromDate!!
                )
            )
        // treeName + adoptionToDate
        else if (
            filter.hasTreeName()            and
            filter.hasAdoptionToDate()      and
            !filter.hasAdoptionFromDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByTreeName
                .findAdoptionsByTreeNameAndAdoptionToDate(
                    filter.treeName!!,
                    filter.adoptionToDate!!
                )
            )
        // treeName + adoptionFromDate + adoptionToDate
        else if (
            filter.hasTreeName()            and
            filter.hasAdoptionFromDate()    and
            filter.hasAdoptionToDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByTreeName
                .findAdoptionsByTreeNameAndAdoptionFromDateAndAdoptionToDate(
                    filter.treeName!!,
                    filter.adoptionFromDate!!,
                    filter.adoptionToDate!!
                )
            )
    }
    fun filterWhenTreeSpeciesAndDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>) {
        // treeSpecies + adoptionFromDate
        if (
            filter.hasTreeSpecies()         and
            filter.hasAdoptionFromDate()    and
            !filter.hasAdoptionToDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByTreeSpecies
                .findAdoptionsByTreeSpeciesAndAdoptionFromDate(
                    filter.treeSpecies!!,
                    filter.adoptionFromDate!!
                )
            )
        // treeSpecies + adoptionToDate
        else if (
            filter.hasTreeSpecies()         and
            filter.hasAdoptionToDate()      and
            !filter.hasAdoptionFromDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByTreeSpecies
                .findAdoptionsByTreeSpeciesAndAdoptionToDate(
                    filter.treeSpecies!!,
                    filter.adoptionToDate!!
                )
            )
        // treeSpecies + adoptionFromDate + adoptionToDate
        else if (
            filter.hasTreeSpecies()         and
            filter.hasAdoptionFromDate()    and
            filter.hasAdoptionToDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByTreeSpecies
                .findAdoptionsByTreeSpeciesAndAdoptionFromDateAndAdoptionToDate(
                    filter.treeSpecies!!,
                    filter.adoptionFromDate!!,
                    filter.adoptionToDate!!
                )
            )
    }
    fun filterWhenDistrictAndDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>) {
        // district + adoptionFromDate
        if (
            filter.hasAdoptionDistrict() and
            filter.hasAdoptionFromDate() and
            !filter.hasAdoptionToDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByDistrict
                .findAdoptionsByDistrictAndAdoptionFromDate(
                    filter.adoptionDistrict!!,
                    filter.adoptionFromDate!!
                )
            )
        // district + adoptionToDate
        else if (
            filter.hasAdoptionDistrict() and
            filter.hasAdoptionToDate() and
            !filter.hasAdoptionFromDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByDistrict
                .findAdoptionsByDistrictAndAdoptionToDate(
                    filter.adoptionDistrict!!,
                    filter.adoptionToDate!!
                )
            )
        // district + adoptionFromDate + adoptionToDate
        else if (
            filter.hasAdoptionDistrict() and
            filter.hasAdoptionFromDate() and
            filter.hasAdoptionToDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByDistrict
                .findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
                    filter.adoptionDistrict!!,
                    filter.adoptionFromDate!!,
                    filter.adoptionToDate!!
                )
            )
    }
    fun filterWhenNeighAndDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>) {
        // neigh + adoptionFromDate
        if (
            filter.hasAdoptionNeigh()       and
            filter.hasAdoptionFromDate()    and
            !filter.hasAdoptionToDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByNeigh
                .findAdoptionsByNeighAndAdoptionFromDate(
                    filter.adoptionNeigh!!,
                    filter.adoptionFromDate!!
                )
            )
        // neigh + adoptionToDate
        else if (
            filter.hasAdoptionNeigh()       and
            filter.hasAdoptionToDate()      and
            !filter.hasAdoptionFromDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByNeigh
                .findAdoptionsByNeighAndAdoptionToDate(
                    filter.adoptionNeigh!!,
                    filter.adoptionToDate!!
                )
            )
        // neigh + adoptionFromDate + adoptionToDate
        else if (
            filter.hasAdoptionNeigh()       and
            filter.hasAdoptionFromDate()    and
            filter.hasAdoptionToDate()
        )
            adoptions.addAll(searchByAdoption.searchAdoptionByNeigh
                .findAdoptionsByNeighAndAdoptionFromDateAndAdoptionToDate(
                    filter.adoptionNeigh!!,
                    filter.adoptionFromDate!!,
                    filter.adoptionToDate!!
                )
            )
    }
    fun filterWhenOnlyDates(filter: FilterJSONAdoptionDTO, adoptions: MutableList<Adoption>): List<Adoption> {
        if (filter.hasAdoptionFromDate() and !filter.hasAdoptionToDate())
            adoptions.addAll(searchByAdoption.searchAdoptionByDates
                .findAdoptionsByAdoptionFromDate(filter.adoptionFromDate!!))
        else if (filter.hasAdoptionToDate() and !filter.hasAdoptionFromDate())
            adoptions.addAll(searchByAdoption.searchAdoptionByDates
                .findAdoptionsByAdoptionToDate(filter.adoptionToDate!!))
        else
            adoptions.addAll(searchByAdoption.searchAdoptionByDates
                .findAdoptionsByAdoptionFromDateAndAdoptionToDate(
                    filter.adoptionFromDate!!,
                    filter.adoptionToDate!!
                )
            )
        return adoptions.distinct()
    }
}
