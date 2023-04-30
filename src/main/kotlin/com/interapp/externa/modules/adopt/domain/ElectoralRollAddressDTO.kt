package com.interapp.externa.modules.adopt.domain

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
