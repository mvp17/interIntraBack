package com.interapp.externa.app.personalSpace.domain.repositories

import com.interapp.externa.app.personalSpace.domain.entities.Godfather
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GodfatherRepository: JpaRepository<Godfather, Long>
