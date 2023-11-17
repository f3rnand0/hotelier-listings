package com.challenge.hotelier.listings.entity

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "seq_pk_location", sequenceName = "LOCATION_SEQUENCE", initialValue = 1000, allocationSize = 1)
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pk_location")
    var id: Long? = null,
    val city: String,
    val state: String,
    val country: String,
    val zipCode: Int,
    val address: String,

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    val items: List<Item?>? = null
)
