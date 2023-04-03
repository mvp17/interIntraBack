package com.interapp.externa.modules.confirmAdoption.infrastructure

import com.interapp.externa.modules.confirmAdoption.domain.AdoptionConfirmationRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/confirmar")
class AdoptionPostController {

    @PostMapping
    fun confirmAdoption(@RequestBody body: AdoptionConfirmationRequest) {
        val adoptionDTO = body.adoptionDTO
        val treeDTO = body.treeDTO
        val consentDTO = body.consentDTO
        val godfatherDTO = body.godfatherDTO
        val electoralRollAddressDTO = body.electoralRollAddressDTO
        val bdcLocationDTO = body.bdcLocationDTO

    }
}
