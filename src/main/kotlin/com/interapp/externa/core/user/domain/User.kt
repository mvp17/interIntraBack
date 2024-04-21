@file:Suppress("JpaDataSourceORMInspection")

package com.interapp.externa.core.user.domain

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
data class User(
    @Column(name = "username")
    val name: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "passw")
    var password: String,

    @Id
    @SequenceGenerator(name = "\"usuarios_id_seq\"", allocationSize = 1)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "\"usuarios_id_seq\""
    )
    @Column(name = "id")
    val id: Long
)
