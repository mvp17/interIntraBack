package com.interapp.externa.modules.searchByEntity.application.utils

import com.interapp.externa.modules.searchByEntity.application.SearchByGodfather
import com.interapp.externa.modules.searchByEntity.domain.FilterJSONGodfatherDTO
import com.interapp.externa.core.godfather.domain.Godfather
import org.springframework.stereotype.Service

@Service
class GodfatherFilterUtils(val searchByGodfather: SearchByGodfather) {
    fun filterWhenNoDates(filter: FilterJSONGodfatherDTO, godfathers: MutableList<Godfather>): List<Godfather> {
        if (filter.hasGodfatherName())
            godfathers.addAll(searchByGodfather.searchGodfatherByName
                .findGodfathersByName(filter.godfatherName!!)
            )
        if (filter.hasGodfatherLastName1())
            godfathers.addAll(searchByGodfather.searchGodfatherByLastName1
                .findGodfathersByLastName1(filter.godfatherLastName1!!)
            )
        if (filter.hasGodfatherLastName2())
            godfathers.addAll(searchByGodfather.searchGodfatherByLastName2
                .findGodfathersByLastName2(filter.godfatherLastName2!!)
            )
        if (filter.hasGodfatherGender())
            godfathers.addAll(searchByGodfather.searchGodfatherByGender
                .findGodfathersByGender(filter.godfatherGender!!)
            )
        if (filter.hasGodfatherDistrict())
            godfathers.addAll(searchByGodfather.searchGodfatherByDistrict
                .findGodfathersByDistrict(filter.godfatherDistrict!!)
            )
        if (filter.hasGodfatherNeigh())
            godfathers.addAll(searchByGodfather.searchGodfatherByNeigh
                .findGodfathersByNeigh(filter.godfatherNeigh!!)
            )
        return godfathers.distinct()
    }

    fun filterWhenNameAndDates(filter: FilterJSONGodfatherDTO, godfathers: MutableList<Godfather>) {
        // name + birthdayFromDate
        if (filter.hasGodfatherName()             and
            filter.hasGodfatherBirthdayFromDate() and
            !filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByName
                .findGodfathersByNameAndBirthdayFromDate(
                    filter.godfatherName!!,
                    filter.godfatherBirthdayFromDate!!
                )
            )
        // name + birthdayToDate
        else if (
            filter.hasGodfatherName()               and
            filter.hasGodfatherBirthdayToDate()     and
            !filter.hasGodfatherBirthdayFromDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByName
                .findGodfathersByNameAndBirthdayToDate(
                    filter.godfatherName!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
        // name + birthdayFromDate + birthdayToDate
        else if (
            filter.hasGodfatherName()               and
            filter.hasGodfatherBirthdayFromDate()   and
            filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByName
                .findGodfathersByNameAndBirthdayFromDateAndBirthdayToDate(
                    filter.godfatherName!!,
                    filter.godfatherBirthdayFromDate!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
    }

    fun filterWhenLastName1AndDates(filter: FilterJSONGodfatherDTO, godfathers: MutableList<Godfather>) {
        // lastName1 + birthdayFromDate
        if (
            filter.hasGodfatherLastName1() and
            filter.hasGodfatherBirthdayFromDate() and
            !filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByLastName1
                .findGodfathersByLastName1AndBirthdayFromDate(
                    filter.godfatherLastName1!!,
                    filter.godfatherBirthdayFromDate!!
                )
            )
        // lastName1 + birthdayToDate
        else if (
            filter.hasGodfatherLastName1()          and
            filter.hasGodfatherBirthdayToDate()     and
            !filter.hasGodfatherBirthdayFromDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByLastName1
                .findGodfathersByLastName1AndBirthdayToDate(
                    filter.godfatherLastName1!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
        // lastName1 + birthdayFromDate + birthdayToDate
        else if (
            filter.hasGodfatherLastName1()          and
            filter.hasGodfatherBirthdayFromDate()   and
            filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByLastName1
                .findGodfathersByLastName1AndBirthdayFromDateAndBirthdayToDate(
                    filter.godfatherLastName1!!,
                    filter.godfatherBirthdayFromDate!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
    }

    fun filterWhenLastName2AndDates(filter: FilterJSONGodfatherDTO, godfathers: MutableList<Godfather>) {
        // lastName2 + birthdayFromDate
        if (
            filter.hasGodfatherLastName2() and
            filter.hasGodfatherBirthdayFromDate() and
            !filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByLastName2
                .findGodfathersByLastName2AndBirthdayFromDate(
                    filter.godfatherLastName2!!,
                    filter.godfatherBirthdayFromDate!!
                )
            )
        // lastName2 + birthdayToDate
        else if (
            filter.hasGodfatherLastName2()          and
            filter.hasGodfatherBirthdayToDate()     and
            !filter.hasGodfatherBirthdayFromDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByLastName2
                .findGodfathersByLastName2AndBirthdayToDate(
                    filter.godfatherLastName2!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
        // lastName2 + birthdayFromDate + birthdayToDate
        else if (
            filter.hasGodfatherLastName2()          and
            filter.hasGodfatherBirthdayFromDate()   and
            filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByLastName2
                .findGodfathersByLastName2AndBirthdayFromDateAndBirthdayToDate(
                    filter.godfatherLastName2!!,
                    filter.godfatherBirthdayFromDate!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
    }

    fun filterWhenGenderAndDates(filter: FilterJSONGodfatherDTO, godfathers: MutableList<Godfather>) {
        // gender + birthdayFromDate
        if (
            filter.hasGodfatherGender()             and
            filter.hasGodfatherBirthdayFromDate()   and
            !filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByGender
                .findGodfathersByGenderAndBirthdayFromDate(
                    filter.godfatherGender!!,
                    filter.godfatherBirthdayFromDate!!
                )
            )
        // gender + birthdayToDate
        else if (
            filter.hasGodfatherGender()             and
            filter.hasGodfatherBirthdayToDate()     and
            !filter.hasGodfatherBirthdayFromDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByGender
                .findGodfathersByGenderAndBirthdayToDate(
                    filter.godfatherGender!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
        // gender + birthdayFromDate + birthdayToDate
        else if (
            filter.hasGodfatherGender()             and
            filter.hasGodfatherBirthdayFromDate()   and
            filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByGender
                .findGodfathersByGenderAndBirthdayFromDateAndBirthdayToDate(
                    filter.godfatherGender!!,
                    filter.godfatherBirthdayFromDate!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
    }

    fun filterWhenDistrictAndDates(filter: FilterJSONGodfatherDTO, godfathers: MutableList<Godfather>) {
        // district + birthdayFromDate
        if (filter.hasGodfatherDistrict()           and
            filter.hasGodfatherBirthdayFromDate()   and
            !filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByDistrict
                .findGodfathersByDistrictAndBirthdayFromDate(
                    filter.godfatherDistrict!!,
                    filter.godfatherBirthdayFromDate!!
                )
            )
        // district + birthdayToDate
        else if (
            filter.hasGodfatherDistrict() and
            filter.hasGodfatherBirthdayToDate() and
            !filter.hasGodfatherBirthdayFromDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByDistrict
                .findGodfathersByDistrictAndBirthdayToDate(
                    filter.godfatherDistrict!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
        // district + birthdayFromDate + birthdayToDate
        else if (
            filter.hasGodfatherDistrict()           and
            filter.hasGodfatherBirthdayFromDate()   and
            filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByDistrict
                .findGodfathersByDistrictAndBirthdayFromDateAndBirthdayToDate(
                    filter.godfatherDistrict!!,
                    filter.godfatherBirthdayFromDate!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
    }

    fun filterWhenNeighAndDates(filter: FilterJSONGodfatherDTO, godfathers: MutableList<Godfather>) {
        // neigh + birthdayFromDate
        if (filter.hasGodfatherNeigh()              and
            filter.hasGodfatherBirthdayFromDate()   and
            !filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByNeigh
                .findGodfathersByNeighAndBirthdayFromDate(
                    filter.godfatherNeigh!!,
                    filter.godfatherBirthdayFromDate!!
                )
            )
        // neigh + birthdayToDate
        else if (
            filter.hasGodfatherNeigh() and
            filter.hasGodfatherBirthdayToDate() and
            !filter.hasGodfatherBirthdayFromDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByNeigh
                .findGodfathersByNeighAndBirthdayToDate(
                    filter.godfatherNeigh!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
        // neigh + birthdayFromDate + birthdayToDate
        else if (
            filter.hasGodfatherNeigh()           and
            filter.hasGodfatherBirthdayFromDate()   and
            filter.hasGodfatherBirthdayToDate()
        )
            godfathers.addAll(searchByGodfather.searchGodfatherByNeigh
                .findGodfathersByNeighAndBirthdayFromDateAndBirthdayToDate(
                    filter.godfatherNeigh!!,
                    filter.godfatherBirthdayFromDate!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
    }

    fun filterWhenOnlyDates(filter: FilterJSONGodfatherDTO, godfathers: MutableList<Godfather>): List<Godfather> {
        if (filter.hasGodfatherBirthdayFromDate() and !filter.hasGodfatherBirthdayToDate())
            godfathers.addAll(searchByGodfather.searchGodfatherByBirthdayDates
                .findGodfathersByBirthdayFromDate(filter.godfatherBirthdayFromDate!!))
        else if (filter.hasGodfatherBirthdayToDate() and !filter.hasGodfatherBirthdayFromDate())
            godfathers.addAll(searchByGodfather.searchGodfatherByBirthdayDates
                .findGodfathersByBirthdayToDate(filter.godfatherBirthdayToDate!!))
        else
            godfathers.addAll(searchByGodfather.searchGodfatherByBirthdayDates
                .findGodfathersByBirthdayFromDateAndBirthdayToDate(
                    filter.godfatherBirthdayFromDate!!,
                    filter.godfatherBirthdayToDate!!
                )
            )
        return godfathers.distinct()
    }
}
