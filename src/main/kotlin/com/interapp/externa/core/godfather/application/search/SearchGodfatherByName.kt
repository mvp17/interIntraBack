package com.interapp.externa.core.godfather.application.search

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.GodfatherRepo
import org.springframework.stereotype.Service

@Service
class SearchGodfatherByName(private val godfatherRepo: GodfatherRepo) {
    fun findGodfathersByName(name: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByName(name)
    }
    fun findGodfathersByNameAndBirthdayFromDate(name: String, fromDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByNameAndBirthdayFromDate(name, fromDate)
    }
    fun findGodfathersByNameAndBirthdayToDate(name: String, toDate: String): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByNameAndBirthdayToDate(name, toDate)
    }
    fun findGodfathersByNameAndBirthdayFromDateAndBirthdayToDate(
        name: String, fromDate: String, toDate: String
    ): MutableList<Godfather> {
        return godfatherRepo.findGodfathersByNameAndBirthdayFromDateAndBirthdayToDate(name, fromDate, toDate)
    }
    fun findGodfatherByNameAndBirthday(name: String, birthday: String): Godfather? {
        return godfatherRepo.findGodfatherByNameAndBirthday(name, birthday)
    }
}
