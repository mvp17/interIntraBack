package com.interapp.externa.modules.myAdoptions.infrastructure

import com.interapp.externa.core.adoption.application.AdoptionService
import com.interapp.externa.core.consent.application.ConsentService
import com.interapp.externa.core.godfather.application.GodfatherService
import com.interapp.externa.modules.myAdoptions.domain.RevokeDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/myAdoptions")
class RevokeAdoptionPostController(
    private val adoptionService: AdoptionService,
    private val godfatherService: GodfatherService,
    private val consentService: ConsentService
) {
    @PostMapping("/adoption/revoke")
    fun revokeAdoption(@RequestBody body: RevokeDTO) {
        val consent = consentService.findConsentByAdoptionId(body.adoptionId)
        consentService.deleteConsent(consent)
        adoptionService.deleteAdoptionById(body.adoptionId)
        godfatherService.deleteGodfatherById(body.godfatherId)
    }
}
