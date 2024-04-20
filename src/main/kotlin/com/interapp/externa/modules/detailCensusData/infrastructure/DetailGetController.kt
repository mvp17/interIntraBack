package com.interapp.externa.modules.detailCensusData.infrastructure

import com.interapp.externa.modules.detailCensusData.domain.*
import com.interapp.externa.core.adoption.application.search.SearchAdoptionById
import com.interapp.externa.core.consent.application.ConsentSearch
import com.interapp.externa.modules.searchByEntity.application.SearchByGodfather
import com.interapp.externa.core.bdcLocation.application.BDCLocationSearch
import com.interapp.externa.core.censusAddress.application.CensusAddressSearch
import com.interapp.externa.core.representative.application.RepresentativeSearch
import com.interapp.externa.core.tree.application.TreeSearch
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/detailCensus/adoption")
class DetailGetController(
    private val searchByGodfather: SearchByGodfather,
    private val searchAdoptionById: SearchAdoptionById,
    private val representativeSearch: RepresentativeSearch,
    private val treeSearch: TreeSearch,
    private val consentSearch: ConsentSearch,
    private val censusAddressSearch: CensusAddressSearch,
    private val bdcLocationSearch: BDCLocationSearch
    ) {
    @GetMapping("/{id}")
    fun getDetailCensusDataForAdoptionByAdoptionId(@PathVariable id: Long): ResponseDTO {
        val adoption = searchAdoptionById.findAdoptionById(id)
        // LocalDate.parse(adoption.adoptionDate).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
        val adoptionDTO = AdoptionDTO(adoption.id, adoption.adoptionDate.toString())
        val godfather = searchByGodfather.searchGodfatherById.findGodfatherById(adoption.godfatherId)
        val representative = representativeSearch.findRepresentativeById(adoption.representativeId)
        val tree = treeSearch.findTreeById(adoption.treeId)
        val treeDTO = TreeDTO(
            tree.id,
            tree.treePositionId,
            tree.xCoord,
            tree.yCoord,
            tree.commonName,
            tree.species,
            adoption.district,
            adoption.neigh,
            adoption.distance
        )
        val consent = consentSearch.findConsentByRepresentativeId(adoption.representativeId)
        val censusAddress = censusAddressSearch.findCensusAddressByRepresentativeId(adoption.representativeId)
        val censusAddressDTO = CensusAddressDTO(
            censusAddress.streetType,
            censusAddress.streetName,
            censusAddress.streetNumber,
            censusAddress.staircase,
            censusAddress.floor,
            censusAddress.door,
            censusAddress.zipCode
        )
        val bdcLocation = bdcLocationSearch.findBDCLocationByRepresentativeId(adoption.representativeId)
        val bdcLocationDTO = BDCLocationDTO(
            bdcLocation.streetType,
            bdcLocation.streetName,
            bdcLocation.streetName,
            bdcLocation.staircase,
            bdcLocation.floor,
            bdcLocation.door,
            bdcLocation.zipCode,
            bdcLocation.ndpBDCClass,
            bdcLocation.ndp,
            bdcLocation.xCoord,
            bdcLocation.yCoord,
            bdcLocation.district,
            bdcLocation.neigh
        )
        return ResponseDTO(godfather, representative, adoptionDTO, treeDTO, consent, censusAddressDTO, bdcLocationDTO)
    }
}