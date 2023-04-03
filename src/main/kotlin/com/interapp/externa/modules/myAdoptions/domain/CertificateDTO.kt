package com.interapp.externa.modules.myAdoptions.domain

data class CertificateDTO(
    val godfatherName: String,
    val godfatherBirthday: String,
    val treeName: String,
    val treeSpecies: String,
    val adoptedTreeDistrict: String,
    val xCoord: Float,
    val yCoord: Float,
)
