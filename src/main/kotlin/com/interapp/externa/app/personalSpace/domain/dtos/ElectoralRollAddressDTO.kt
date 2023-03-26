package com.interapp.externa.app.personalSpace.domain.dtos

data class ElectoralRollAddressDTO(
    val paStreetType: String,
    val paStreetName: String,
    val paStreetNumber: String,
    val paStaircase: String,
    val paFloor: String,
    val paDoor: String,
    val paZipCode: String,
    val id: Long
)
