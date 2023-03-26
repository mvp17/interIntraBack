package com.interapp.externa.app.personalSpace.domain.entities

import jakarta.persistence.*

@Entity
@Table(name = "padron_address")
class ElectoralRollAddress(
    @Column(name = "dp_tipo_via")
    var paStreetType: String,

    @Column(name = "dp_nombre_via")
    var paStreetName: String,

    @Column(name = "dp_numero_via")
    var paStreetNumber: String,

    @Column(name = "dp_escalera")
    val paStaircase: String,

    @Column(name = "dp_planta")
    val paFloor: String,

    @Column(name = "dp_puerta")
    val paDoor: String,

    @Column(name = "dp_codigo_postal")
    val paZipCode: String,

    @Column(name = "id_padrino")
    val godfatherId: Long,

    @Column(name = "id_representante")
    val representativeId: Long,

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
