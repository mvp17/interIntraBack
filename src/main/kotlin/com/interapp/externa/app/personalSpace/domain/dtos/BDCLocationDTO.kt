package com.interapp.externa.app.personalSpace.domain.dtos

data class BDCLocationDTO(
    val streetType: String,
    val streetName: String,
    val streetNumber: String,
    val staircase: String,
    val floor: String,
    val door: String,
    val zipCode: String,
    val qualifier: String,
    val ndpBDCClass: String,
    val ndp: String,
    val xCoord: Float,
    val yCoord: Float,
    val district: String,
    val neigh: String,
    val id: Long
)
