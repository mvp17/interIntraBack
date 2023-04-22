package com.interapp.externa.core.adoption.domain

import jakarta.persistence.*
import java.sql.Date


@Entity
@Table(name = "adoptions")
data class Adoption(
    @Column(name = "adoption_date")
    var adoptionDate: Date,

    @Column(name = "godfather_id")
    var godfatherId: Long,

    @Column(name = "representative_id")
    var representativeId: Long,

    @Column(name = "tree_id")
    var treeId: Long,

    @Column(name = "district")
    var district: String,

    @Column(name = "neigh")
    var neigh: String,

    @Column(name = "distance_godfather")
    var distance: Float,

    @Id
    @SequenceGenerator(
        name = "\"adoptions_id_seq\"",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "\"adoptions_id_seq\""
    )
    @Column(name = "id")
    val id: Long
)
