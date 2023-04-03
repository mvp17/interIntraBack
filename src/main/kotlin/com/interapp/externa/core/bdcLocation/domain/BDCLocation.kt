package com.interapp.externa.core.bdcLocation.domain

import jakarta.persistence.*

@Entity
@Table(name = "bdc_location")
data class BDCLocation(
    @Column(name = "tipo_via")
    var streetType: String,

    @Column(name = "nombre_via")
    var streetName: String,

    @Column(name = "numero_via")
    var streetNumber: String,

    @Column(name = "escalera")
    val staircase: String,

    @Column(name = "planta")
    val floor: String,

    @Column(name = "puerta")
    val door: String,

    @Column(name = "codigo_postal")
    val zipCode: String,

    @Column(name = "calificador")
    val qualifier: String,

    @Column(name = "clase_ndp_bdc")
    val ndpBDCClass: String,

    @Column(name = "ndp")
    val ndp: String,

    @Column(name = "coord_x")
    val xCoord: Float,

    @Column(name = "coord_y")
    val yCoord: Float,

    @Column(name = "distrito")
    val district: String,

    @Column(name = "barrio")
    val neigh: String,

    @Column(name = "representante_id")
    val representativeId: Long,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
