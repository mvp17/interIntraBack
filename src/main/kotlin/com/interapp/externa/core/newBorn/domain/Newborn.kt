package com.interapp.externa.core.newBorn.domain

import jakarta.persistence.*

@Entity
@Table(name = "recien_nacidos")
data class Newborn(
    @Column(name = "name")
    var name: String,

    @Column(name = "last_name1")
    var lastName1: String,

    @Column(name = "last_name2")
    var lastName2: String,

    @Column(name = "gender")
    val gender: String,

    @Column(name = "birthday")
    var birthday: String,

    @Column(name = "representative_id")
    val representativeId: Long,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
