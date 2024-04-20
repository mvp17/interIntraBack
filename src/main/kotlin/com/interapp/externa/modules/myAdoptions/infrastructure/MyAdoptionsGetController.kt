package com.interapp.externa.modules.myAdoptions.infrastructure

import com.interapp.externa.core.adoption.application.search.SearchAdoptionById
import com.interapp.externa.modules.myAdoptions.domain.AdoptionDTO
import com.interapp.externa.core.godfather.application.search.SearchGodfatherById
import com.interapp.externa.core.tree.application.TreeSearch
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/representative/adoptions")
class MyAdoptionsGetController(
    private val searchAdoptionById: SearchAdoptionById,
    private val searchGodfatherById: SearchGodfatherById,
    private val treeSearch: TreeSearch
) {
    @GetMapping("/{id}")
    fun getAdoptionsFromRepresentative(@PathVariable id: Long): MutableList<AdoptionDTO> {
        val adoptions = searchAdoptionById.findAdoptionsByRepresentativeId(id)
        val adoptionsDTO = mutableListOf<AdoptionDTO>()
        for (adoption in adoptions) {
            val godfather = searchGodfatherById.findGodfatherById(adoption.godfatherId)
            val tree = treeSearch.findTreeById(adoption.treeId)
            val adoptionDTO = AdoptionDTO(adoption.id,
                                          adoption.godfatherId,
                                          godfather.name,
                                          tree.commonName,
                                          tree.xCoord,
                                          tree.yCoord,
                                          adoption.distance,
                                          adoption.representativeId,
                                          tree.treePositionId
                                        )
            adoptionsDTO.add(adoptionDTO)
        }
        return adoptionsDTO
    }
}
