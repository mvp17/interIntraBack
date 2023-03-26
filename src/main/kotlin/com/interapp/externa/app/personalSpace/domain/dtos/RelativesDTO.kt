package com.interapp.externa.app.personalSpace.domain.dtos

import com.interapp.externa.app.personalSpace.domain.entities.Representative

data class RelativesDTO(
    val representative: Representative,
    val godfathers: MutableList<GodfatherDTO>,
    val padronAddress: ElectoralRollAddressDTO,
    val bdcLocation: BDCLocationDTO
)
