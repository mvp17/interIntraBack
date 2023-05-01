package com.interapp.externa.core.godfather.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface GodfatherRepository: JpaRepository<Godfather, Long> {
    @Query("select g from Godfather g where g.name = ?1 and g.birthday = date(?2)")
    fun findGodfatherByNameAndBirthday(name: String, birthday: String): Godfather?
}
