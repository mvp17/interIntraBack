package com.interapp.externa.core.representative.domain

import jakarta.persistence.*

@Entity
@Table(name = "representative")
data class Representative(
    @Column(name = "nombre")
    var name: String,

    @Column(name = "apellido1")
    var lastName1: String,

    @Column(name = "apellido2")
    var lastName2: String,

    @Column(name = "fecha_nacimiento")
    val birthday: String,

    @Column(name = "nif_nie")
    val nifNie: String,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
