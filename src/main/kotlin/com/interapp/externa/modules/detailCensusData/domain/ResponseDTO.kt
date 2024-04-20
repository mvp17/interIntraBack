package com.interapp.externa.modules.detailCensusData.domain

import com.interapp.externa.core.consent.domain.Consent
import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.representative.domain.Representative

data class ResponseDTO(
    val godfather: Godfather,
    val representative: Representative,
    val adoption: AdoptionDTO,
    val tree: TreeDTO,
    val consent: Consent,
    val censusAddress: CensusAddressDTO,
    val bdcLocation: BDCLocationDTO
)
