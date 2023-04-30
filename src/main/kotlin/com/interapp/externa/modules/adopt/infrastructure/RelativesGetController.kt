package com.interapp.externa.modules.adopt.infrastructure

import com.interapp.externa.core.bdcLocation.application.BDCLocationSearch
import com.interapp.externa.core.electoralRollAddress.application.ElectoralRollAddressSearch
import com.interapp.externa.core.newBorn.application.NewBornSearch
import com.interapp.externa.core.representative.application.RepresentativeSearch
import com.interapp.externa.modules.adopt.domain.BDCLocationDTO
import com.interapp.externa.modules.adopt.domain.ElectoralRollAddressDTO
import com.interapp.externa.modules.adopt.domain.NewbornDTO
import com.interapp.externa.modules.adopt.domain.RelativesDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/adopt")
class RelativesGetController(
    private val representativeSearch: RepresentativeSearch,
    private val newBornSearch: NewBornSearch,
    private val bdcLocationSearch: BDCLocationSearch,
    private val electoralRollAddressSearch: ElectoralRollAddressSearch
) {

    @GetMapping("/representative/relatives/{id}")
    fun getRelatives(@PathVariable id: Long): RelativesDTO {
        val representative = representativeSearch.findRepresentativeById(id)
        val newborns = newBornSearch.findNewBornsByRepresentativeId(representative.id)
        val newbornsDTO = mutableListOf<NewbornDTO>()
        for (newborn in newborns) {
            val newbornDTO = NewbornDTO(newborn.name,
                                          newborn.lastName1,
                                          newborn.lastName2,
                                          newborn.gender,
                                          newborn.birthday
                                          )
            newbornsDTO.add(newbornDTO)
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
        return RelativesDTO(representative, newbornsDTO, electoralRollAddressDTO ,bdcLocationDTO)
    }
}
