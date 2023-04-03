package com.interapp.externa.modules.personalSpace.domain

import com.interapp.externa.core.representative.domain.Representative

data class RelativesDTO(
    val representative: Representative,
    val newBorns: MutableList<NewBornDTO>,
    val padronAddress: ElectoralRollAddressDTO,
    val bdcLocation: BDCLocationDTO
)
