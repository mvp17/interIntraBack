package com.interapp.externa.core.newBorn.application

import com.interapp.externa.core.newBorn.domain.NewBorn
import com.interapp.externa.core.newBorn.domain.NewBornRepository
import org.springframework.stereotype.Service

@Service
class NewBornSearch(private val newBornRepository: NewBornRepository) {
    fun findNewBornsByRepresentativeId(id: Long): MutableList<NewBorn> {
        return newBornRepository.findNewBornsByRepresentativeId(id)
    }
}
