package com.interapp.externa.core.godfather.application


import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.GodfatherRepo
import org.springframework.stereotype.Service

@Service
class GodfatherService(private val godfatherRepository: GodfatherRepo) {
    fun addGodfather(godfather: Godfather): Godfather {
        return godfatherRepository.save(godfather)
    }
    fun deleteGodfatherById(id: Long) {
        godfatherRepository.deleteById(id)
    }
}
