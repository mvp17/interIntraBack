package com.interapp.externa.modules.searchByEntity.application

import com.interapp.externa.core.adoption.application.search.*
import org.springframework.stereotype.Service

@Service
class SearchByAdoption(
    val searchAdoptionById: SearchAdoptionById,
    val searchAdoptionByTreeName: SearchAdoptionByTreeName,
    val searchAdoptionByTreeSpecies: SearchAdoptionByTreeSpecies,
    val searchAdoptionByDistrict: SearchAdoptionByDistrict,
    val searchAdoptionByNeigh: SearchAdoptionByNeigh,
    val searchAdoptionByDates: SearchAdoptionByDates,
)
