package com.interapp.externa.modules.detailCensusData.domain

data class CensusAddressDTO(
    val streetType: String,
    val streetName: String,
    val streetNumber: String,
    val staircase: String,
    val floor: String,
    val door: String,
    val zipCode: String
)
