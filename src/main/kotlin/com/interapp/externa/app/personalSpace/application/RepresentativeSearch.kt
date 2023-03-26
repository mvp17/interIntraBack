package com.interapp.externa.app.personalSpace.application

import com.interapp.externa.app.personalSpace.domain.entities.Representative
import com.interapp.externa.app.personalSpace.domain.repositories.RepresentativeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RepresentativeSearch(private val representativeRepository: RepresentativeRepository) {
    fun findRepresentativeById(id: Long): Representative {
        return representativeRepository.findById(id)
            .orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Representative not found!")
            }
    }
}
