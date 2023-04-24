package com.interapp.externa.core.godfather.application

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.GodfatherRepository
import org.springframework.stereotype.Service

@Service
class GodfatherService(
    private val godfatherRepository: GodfatherRepository
) {
    fun findGodfatherById(id: Long): Godfather {
        return godfatherRepository.findById(id).orElseThrow()
    }

    fun addGodfather(godfather: Godfather): Godfather {
        return godfatherRepository.save(godfather)
    }

    fun findGodfatherByNameAndBirthday(name: String, birthday: String): Godfather? {
        return godfatherRepository.findGodfatherByNameAndBirthday(name, birthday)
    }
}
