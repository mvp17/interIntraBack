package com.interapp.externa.modules.detailCensusData.domain

data class TreeDTO(
    val id: Number,
    val treePositionId: Number,
    val xCoord: Number,
    val yCoord: Number,
    val commonName: String,
    val species: String,
    val district: String,
    val neigh: String,
    val godfatherDistance: Number,
)
