package com.interapp.externa.modules.myAdoptions.infrastructure

import com.interapp.externa.core.adoption.application.AdoptionSearch
import com.interapp.externa.core.godfather.application.GodfatherSearch
import com.interapp.externa.core.tree.application.TreeSearch
import com.interapp.externa.modules.myAdoptions.domain.CertificateDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/representative/adoptions")
class CertificateDataGetController(
    private val adoptionSearch: AdoptionSearch,
    private val godfatherSearch: GodfatherSearch,
    private val treeSearch: TreeSearch
) {
    @GetMapping("/certificate/{adoptionId}")
    fun getCertificateData(@PathVariable adoptionId: Long): CertificateDTO {
        val adoption = adoptionSearch.findAdoptionById(adoptionId)
        val godfather = godfatherSearch.findGodfatherById(adoption.godfatherId)
        val tree = treeSearch.findTreeById(adoption.treeId)
        return CertificateDTO(godfather.name,
            godfather.birthday,
            tree.commonName,
            tree.species,
            adoption.district,
            tree.xCoord,
            tree.yCoord
        )
    }
}
