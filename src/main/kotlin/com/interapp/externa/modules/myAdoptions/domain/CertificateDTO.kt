package com.interapp.externa.modules.myAdoptions.domain

import java.sql.Date

data class CertificateDTO(
    val godfatherName: String,
    val godfatherBirthday: Date,
    val treeName: String,
    val treeSpecies: String,
    val adoptedTreeDistrict: String,
    val xCoord: Float,
    val yCoord: Float,
)
