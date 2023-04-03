package com.interapp.externa.core.representative.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepresentativeRepository: JpaRepository<Representative, Long>
