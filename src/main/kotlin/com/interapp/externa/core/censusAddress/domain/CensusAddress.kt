package com.interapp.externa.core.censusAddress.domain

import jakarta.persistence.*

@Entity
@Table(name = "padron_address")
data class CensusAddress(
    @Column(name = "dp_tipo_via")
    var streetType: String,

    @Column(name = "dp_nombre_via")
    var streetName: String,

    @Column(name = "dp_numero_via")
    var streetNumber: String,

    @Column(name = "dp_escalera")
    val staircase: String,

    @Column(name = "dp_planta")
    val floor: String,

    @Column(name = "dp_puerta")
    val door: String,

    @Column(name = "dp_codigo_postal")
    val zipCode: String,

    @Column(name = "id_padrino")
    val godfatherId: Long,

    @Column(name = "id_representante")
    val representativeId: Long,

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Long
)
