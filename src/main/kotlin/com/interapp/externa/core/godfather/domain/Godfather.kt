package com.interapp.externa.core.godfather.domain

import jakarta.persistence.*
import java.sql.Date


@Entity
@Table(name = "godfathers")
data class Godfather(
    @Column(name = "name")
    var name: String,

    @Column(name = "last_name1")
    var lastName1: String,

    @Column(name = "last_name2")
    var lastName2: String,

    @Column(name = "gender")
    val gender: String,

    @Column(name = "birthday")
    var birthday: Date,

    @Column(name = "district")
    val district: String,

    @Column(name = "neigh")
    val neigh: String,

    @Id
    @SequenceGenerator(
        name = "\"godfathers_id_seq\"",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "\"godfathers_id_seq\""
    )
    @Column(name = "id")
    val id: Long
)
