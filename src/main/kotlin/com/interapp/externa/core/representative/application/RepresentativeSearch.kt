package com.interapp.externa.core.representative.application

import com.interapp.externa.core.representative.domain.Representative
import com.interapp.externa.core.representative.domain.RepresentativeRepository
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

    fun findRepresentatives(): List<Representative> {
        return representativeRepository.findAll()
    }
}
