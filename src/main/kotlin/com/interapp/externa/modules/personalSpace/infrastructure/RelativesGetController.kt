package com.interapp.externa.modules.personalSpace.infrastructure

import com.interapp.externa.core.bdcLocation.application.BDCLocationSearch
import com.interapp.externa.core.electoralRollAddress.application.ElectoralRollAddressSearch
import com.interapp.externa.core.newBorn.application.NewBornSearch
import com.interapp.externa.core.representative.application.RepresentativeSearch
import com.interapp.externa.modules.personalSpace.domain.BDCLocationDTO
import com.interapp.externa.modules.personalSpace.domain.ElectoralRollAddressDTO
import com.interapp.externa.modules.personalSpace.domain.NewBornDTO
import com.interapp.externa.modules.personalSpace.domain.RelativesDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/representative/relatives")
class RelativesGetController(
    private val representativeSearch: RepresentativeSearch,
    private val newBornSearch: NewBornSearch,
    private val bdcLocationSearch: BDCLocationSearch,
    private val electoralRollAddressSearch: ElectoralRollAddressSearch
) {

    @GetMapping("/{id}")
    fun getRelatives(@PathVariable id: Long): RelativesDTO {
        val representative = representativeSearch.findRepresentativeById(id)
        val newBorns = newBornSearch.findNewBornsByRepresentativeId(representative.id)
        val newBornsDTO = mutableListOf<NewBornDTO>()
        for (newBorn in newBorns) {
            val newBornDTO = NewBornDTO(newBorn.name,
                                          newBorn.lastName1,
                                          newBorn.lastName2,
                                          newBorn.gender,
                                          newBorn.birthday
                                          )
            newBornsDTO.add(newBornDTO)
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
        return RelativesDTO(representative, newBornsDTO, electoralRollAddressDTO ,bdcLocationDTO)
    }
}
