package com.interapp.externa.modules.confirmAdoption.infrastructure

import com.interapp.externa.core.adoption.application.AdoptionService
import com.interapp.externa.core.adoption.domain.Adoption
import com.interapp.externa.core.consent.application.ConsentService
import com.interapp.externa.core.consent.domain.Consent
import com.interapp.externa.core.godfather.application.GodfatherService
import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.modules.confirmAdoption.domain.AdoptionConfirmationRequest
import com.interapp.externa.modules.confirmAdoption.domain.ConfirmationResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Date

@RestController
@RequestMapping("/api/v1/confirm-adoption")
class AdoptionPostController(
    private val adoptionService: AdoptionService,
    private val godfatherService: GodfatherService,
    private val consentService: ConsentService
) {
    @PostMapping
    fun confirmAdoption(@RequestBody body: AdoptionConfirmationRequest): ConfirmationResponse {
        val adoptionDTO = body.adoptionDTO
        val treeDTO = body.treeDTO
        val consentDTO = body.consentDTO
        val godfatherDTO = body.godfatherDTO
        val bdcLocationDTO = body.bdcLocationDTO

        val currentGodfather: Godfather? = godfatherService
                                                .findGodfatherByNameAndBirthday(godfatherDTO.name,
                                                                                godfatherDTO.birthday)
        var newAdoption:Adoption
        val visibleOthersConsentDate: Date?
        if (currentGodfather != null) {
            Adoption(Date.valueOf(adoptionDTO.adoptionDate),
                     currentGodfather.id,
                     consentDTO.representativeId,
                     treeDTO.id,
                     treeDTO.district,
                     treeDTO.neigh,
                     adoptionDTO.godfatherDistance,
                  0).also { newAdoption = it }
            newAdoption = adoptionService.addAdoption(newAdoption)
            visibleOthersConsentDate = if (!consentDTO.visibleOthersConsentDate.isNullOrEmpty())
                Date.valueOf(consentDTO.visibleOthersConsentDate)
            else null

            Consent(consentDTO.censusConsent,
                    Date.valueOf(consentDTO.censusConsentDate),
                    consentDTO.adultAuthorization,
                    Date.valueOf(consentDTO.adultAuthorizationDate),
                    consentDTO.guardian,
                    Date.valueOf(consentDTO.guardianConsentDate),
                    consentDTO.visibleOthers,
                    visibleOthersConsentDate,
                    consentDTO.comment,
                    consentDTO.representativeId,
                    currentGodfather.id,
                    newAdoption.id,
                 0).also {
                        val newConsent = it
                        consentService.addConsent(newConsent)
                    }
        }
        else {
            var newGodfather = Godfather(godfatherDTO.name,
                                         godfatherDTO.lastName1,
                                         godfatherDTO.lastName2,
                                         godfatherDTO.gender,
                                         Date.valueOf(godfatherDTO.birthday),
                                         bdcLocationDTO.district,
                                         bdcLocationDTO.neigh,
                0)
            newGodfather = godfatherService.addGodfather(newGodfather)
            newAdoption = Adoption(Date.valueOf(adoptionDTO.adoptionDate),
                                   newGodfather.id,
                                   consentDTO.representativeId,
                                   treeDTO.id,
                                   treeDTO.district,
                                   treeDTO.neigh,
                                   adoptionDTO.godfatherDistance,
                                0)
            newAdoption = adoptionService.addAdoption(newAdoption)
            visibleOthersConsentDate = if (!consentDTO.visibleOthersConsentDate.isNullOrEmpty())
                Date.valueOf(consentDTO.visibleOthersConsentDate)
            else null
            val newConsent = Consent(consentDTO.censusConsent,
                                     Date.valueOf(consentDTO.censusConsentDate),
                                     consentDTO.adultAuthorization,
                                     Date.valueOf(consentDTO.adultAuthorizationDate),
                                     consentDTO.guardian,
                                     Date.valueOf(consentDTO.guardianConsentDate),
                                     consentDTO.visibleOthers,
                                     visibleOthersConsentDate,
                                     consentDTO.comment,
                                     consentDTO.representativeId,
                                     newGodfather.id,
                                     newAdoption.id,
                                  0)
            consentService.addConsent(newConsent)
        }
        return ConfirmationResponse(newAdoption.id)
    }
}
