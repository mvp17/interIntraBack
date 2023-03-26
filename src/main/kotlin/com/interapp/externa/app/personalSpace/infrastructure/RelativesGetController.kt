package com.interapp.externa.app.personalSpace.infrastructure

import com.interapp.externa.app.personalSpace.application.BDCLocationSearch
import com.interapp.externa.app.personalSpace.application.GodfatherSearch
import com.interapp.externa.app.personalSpace.application.ElectoralRollAddressSearch
import com.interapp.externa.app.personalSpace.application.RepresentativeSearch
import com.interapp.externa.app.personalSpace.domain.dtos.BDCLocationDTO
import com.interapp.externa.app.personalSpace.domain.dtos.ElectoralRollAddressDTO
import com.interapp.externa.app.personalSpace.domain.dtos.GodfatherDTO
import com.interapp.externa.app.personalSpace.domain.dtos.RelativesDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/representative/relatives")
class RelativesGetController(
    private val representativeSearch: RepresentativeSearch,
    private val godfatherSearch: GodfatherSearch,
    private val bdcLocationSearch: BDCLocationSearch,
    private val electoralRollAddressSearch: ElectoralRollAddressSearch
) {

    @GetMapping("/{id}")
    fun getRelatives(@PathVariable id: Long): RelativesDTO {
        val representative = representativeSearch.findRepresentativeById(id)
        val godfathers = godfatherSearch.findGodfathersByRepresentativeId(representative.id)
        val godfathersDTO = mutableListOf<GodfatherDTO>()
        for (godfather in godfathers) {
            val godfatherDTO = GodfatherDTO(godfather.name,
                                            godfather.lastName1,
                                            godfather.lastName2,
                                            godfather.gender,
                                            godfather.birthday,
                                            godfather.id
                                           )
            godfathersDTO.add(godfatherDTO)
        }
        val electoralRollAddress = electoralRollAddressSearch.findPadronAddressesByRepresentativeId(representative.id)
        val electoralRollAddressDTO = ElectoralRollAddressDTO(electoralRollAddress[0].paStreetType,
                                                              electoralRollAddress[0].paStreetName,
                                                              electoralRollAddress[0].paStreetNumber,
                                                              electoralRollAddress[0].paStaircase,
                                                              electoralRollAddress[0].paFloor,
                                                              electoralRollAddress[0].paDoor,
                                                              electoralRollAddress[0].paZipCode,
                                                              electoralRollAddress[0].id
                                                             )
        val bdcLocation = bdcLocationSearch.findBDCLocationByRepresentativeId(representative.id)
        val bdcLocationDTO = BDCLocationDTO(bdcLocation.streetType,
                                            bdcLocation.streetName,
                                            bdcLocation.streetNumber,
                                            bdcLocation.staircase,
                                            bdcLocation.floor,
                                            bdcLocation.door,
                                            bdcLocation.zipCode,
                                            bdcLocation.qualifier,
                                            bdcLocation.ndpBDCClass,
                                            bdcLocation.ndp,
                                            bdcLocation.xCoord,
                                            bdcLocation.yCoord,
                                            bdcLocation.district,
                                            bdcLocation.neigh,
                                            bdcLocation.id
                                            )
        return RelativesDTO(representative, godfathersDTO, electoralRollAddressDTO ,bdcLocationDTO)
    }
}
