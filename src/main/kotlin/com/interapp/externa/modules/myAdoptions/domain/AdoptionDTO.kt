package com.interapp.externa.modules.myAdoptions.domain

data class AdoptionDTO(
    val id: Long,
    val godfatherId: Long,
    val godfatherName: String,
    val treeName: String,
    val xCoord: Float,
    val yCoord: Float,
    val representativeId: Long,
    val treePositionId: Int,
)
