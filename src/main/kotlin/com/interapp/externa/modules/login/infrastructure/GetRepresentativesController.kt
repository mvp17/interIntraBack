package com.interapp.externa.modules.login.infrastructure

import com.interapp.externa.core.representative.application.RepresentativeSearch
import com.interapp.externa.core.representative.domain.Representative
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class GetRepresentativesController(private val representativeSearch: RepresentativeSearch) {

    @GetMapping("/signin/representatives")
    fun getRepresentatives(): MutableList<Representative> {
        return representativeSearch.findRepresentatives()
    }
}
