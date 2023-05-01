package com.interapp.externa.core.newBorn.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface NewbornRepository: JpaRepository<Newborn, Long> {
    @Query("select nb from Newborn nb where nb.representativeId = ?1")
    fun findNewbornsByRepresentativeId(id: Long): MutableList<Newborn>
}
