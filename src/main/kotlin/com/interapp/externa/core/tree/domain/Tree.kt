@file:Suppress("JpaDataSourceORMInspection")

package com.interapp.externa.core.tree.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@Table(name = "tree")
data class Tree(
    @Column(name = "codigo_posicion_arbolada")
    var treePositionId: Int,

    @Column(name = "nombre_comun")
    var commonName: String,

    @Column(name = "especie")
    var species: String,

    @Column(name = "coord_x")
    var xCoord: Float,

    @Column(name = "coord_y")
    var yCoord: Float,

    @Column(name = "distrito_arbol")
    var district: String,

    @Column(name = "barrio_arbol")
    var neigh: String,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
