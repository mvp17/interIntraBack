package com.interapp.externa.modules.confirmAdoption.domain

import com.interapp.externa.modules.personalSpace.domain.BDCLocationDTO
import com.interapp.externa.modules.personalSpace.domain.ElectoralRollAddressDTO

data class AdoptionConfirmationRequest(
    val adoptionDTO: AdoptionDTO,
    val treeDTO: TreeDTO,
    val consentDTO: ConsentDTO,
    val godfatherDTO: GodfatherDTO,
    val electoralRollAddressDTO: ElectoralRollAddressDTO,
    val bdcLocationDTO: BDCLocationDTO
)
