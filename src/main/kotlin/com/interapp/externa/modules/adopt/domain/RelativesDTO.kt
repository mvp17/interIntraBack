package com.interapp.externa.modules.adopt.domain

import com.interapp.externa.core.representative.domain.Representative

data class RelativesDTO(
    val representative: Representative,
    val newborns: MutableList<NewbornDTO>,
    val electoralRollAddress: ElectoralRollAddressDTO,
    val bdcLocation: BDCLocationDTO
)
