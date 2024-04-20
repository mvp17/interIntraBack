package com.interapp.externa.modules.searchByEntity.domain

data class TableDataResultsDTO(
    var adoptionDate: String,
    val adoptionId: Long,
    val godfatherName: String,
    val godfatherGender: String,
    val godfatherBirthday: String,
    val treeName: String,
    val treeSpecies: String,
    val adoptionDistrict: String,
    val adoptionNeigh: String
)
