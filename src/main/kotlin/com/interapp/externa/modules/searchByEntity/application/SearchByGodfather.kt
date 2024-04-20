package com.interapp.externa.modules.searchByEntity.application

import com.interapp.externa.core.godfather.application.search.*
import org.springframework.stereotype.Service

@Service
class SearchByGodfather(
    val searchGodfatherById: SearchGodfatherById,
    val searchGodfatherByName: SearchGodfatherByName,
    val searchGodfatherByBirthdayDates: SearchGodfatherByBirthdayDates,
    val searchGodfatherByDistrict: SearchGodfatherByDistrict,
    val searchGodfatherByGender: SearchGodfatherByGender,
    val searchGodfatherByLastName1: SearchGodfatherByLastName1,
    val searchGodfatherByLastName2: SearchGodfatherByLastName2,
    val searchGodfatherByNeigh: SearchGodfatherByNeigh
)
