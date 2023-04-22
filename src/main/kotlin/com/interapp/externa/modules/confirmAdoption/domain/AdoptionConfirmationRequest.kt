package com.interapp.externa.modules.confirmAdoption.domain

import com.interapp.externa.modules.personalSpace.domain.BDCLocationDTO

data class AdoptionConfirmationRequest(
    val adoptionDTO: AdoptionDTO,
    val treeDTO: TreeDTO,
    val consentDTO: ConsentDTO,
    val godfatherDTO: GodfatherDTO,
    val bdcLocationDTO: BDCLocationDTO
)
