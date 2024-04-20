package com.interapp.externa.core.godfather.domain.repositories

import com.interapp.externa.core.godfather.domain.Godfather
import com.interapp.externa.core.godfather.domain.repositories.search.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GodfatherRepo:
    JpaRepository<Godfather, Long>,
    SearchByGodfatherNameRepo,
    SearchByGodfatherBirthdayDatesRepo,
    SearchByGodfatherDistrictRepo,
    SearchByGodfatherGenderRepo,
    SearchByGodfatherLastName1Repo,
    SearchByGodfatherLastName2Repo,
    SearchByGodfatherNeighRepo
