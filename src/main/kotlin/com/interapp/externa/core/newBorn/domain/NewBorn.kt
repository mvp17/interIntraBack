package com.interapp.externa.core.newBorn.domain

import jakarta.persistence.*

@Entity
@Table(name = "recien_nacidos")
data class NewBorn(
    @Column(name = "nombre")
    var name: String,

    @Column(name = "apellido1")
    var lastName1: String,

    @Column(name = "apellido2")
    var lastName2: String,

    @Column(name = "genero")
    val gender: String,

    @Column(name = "fecha_nacimiento")
    var birthday: String,

    @Column(name = "representative_id")
    val representativeId: Long,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
