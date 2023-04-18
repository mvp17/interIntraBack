package com.interapp.externa.modules.myAdoptions.infrastructure

import com.interapp.externa.modules.myAdoptions.domain.RevokeDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/representative/adoptions/revoke")
class RevokeAdoptionPostController {
    @PostMapping
    fun revokeAdoption(@RequestBody body: RevokeDTO) {

    }
}
