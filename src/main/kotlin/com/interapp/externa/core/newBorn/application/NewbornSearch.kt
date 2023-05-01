package com.interapp.externa.core.newBorn.application

import com.interapp.externa.core.newBorn.domain.Newborn
import com.interapp.externa.core.newBorn.domain.NewbornRepository
import org.springframework.stereotype.Service

@Service
class NewbornSearch(private val newBornRepository: NewbornRepository) {
    fun findNewbornsByRepresentativeId(id: Long): MutableList<Newborn> {
        return newBornRepository.findNewbornsByRepresentativeId(id)
    }
}
