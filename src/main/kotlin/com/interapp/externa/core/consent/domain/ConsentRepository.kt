package com.interapp.externa.core.consent.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ConsentRepository: JpaRepository<Consent, Long>
