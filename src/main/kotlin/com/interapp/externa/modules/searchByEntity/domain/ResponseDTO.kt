package com.interapp.externa.modules.searchByEntity.domain

data class ResponseDTO(
    val tableDataResultsList: MutableList<TableDataResultsDTO>,
    val totalRecords: Int
)
