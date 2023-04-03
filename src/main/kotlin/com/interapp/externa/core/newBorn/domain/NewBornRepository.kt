package com.interapp.externa.core.newBorn.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface NewBornRepository: JpaRepository<NewBorn, Long> {
    @Query("select nb from NewBorn nb where nb.representativeId = ?1")
    fun findNewBornsByRepresentativeId(id: Long): MutableList<NewBorn>
}
