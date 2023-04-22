package com.interapp.externa.core.adoption.infrastructure

import com.interapp.externa.core.adoption.application.AdoptionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/adoptions")
class AdoptionsGetController(private val adoptionService: AdoptionService) {
    @GetMapping("/total")
    fun getAdoptions(): Int {
        return adoptionService.findAdoptions().count()
    }
}
