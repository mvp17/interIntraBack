package com.interapp.externa.core.adoption.domain

import jakarta.persistence.*


@Entity
@Table(name = "adoption")
data class Adoption(
    @Column(name = "fecha_adopcion")
    var adoptionDate: String,

    @Column(name = "id_padrino")
    var godfatherId: Long,

    @Column(name = "id_representante")
    var representativeId: Long,

    @Column(name = "id_tree")
    var treeId: Long,

    @Column(name = "distrito")
    var district: String,

    @Column(name = "barrio")
    var neigh: String,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
