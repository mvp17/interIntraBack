package com.interapp.externa.core.adoption.domain.repositories

import com.interapp.externa.core.adoption.domain.Adoption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SearchByAdoptionDistrictRepo: JpaRepository<Adoption, Long> {
    @Query("select a from Adoption a where a.district like %?1%")
    fun findAdoptionsByDistrict(district: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.district like %?1% and a.adoptionDate >= date(?2)")
    fun findAdoptionsByDistrictAndAdoptionFromDate(district: String, fromDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.district like %?1% and a.adoptionDate <= date(?2)")
    fun findAdoptionsByDistrictAndAdoptionToDate(district: String, toDate: String): MutableList<Adoption>

    @Query("select a from Adoption a where a.district like %?1% and a.adoptionDate >= date(?2) " +
            "and a.adoptionDate <= date(?3)")
    fun findAdoptionsByDistrictAndAdoptionFromDateAndAdoptionToDate(
        district: String, fromDate: String, toDate: String): MutableList<Adoption>
}
