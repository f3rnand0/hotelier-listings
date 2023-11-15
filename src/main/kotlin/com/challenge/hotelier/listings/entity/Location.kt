package com.challenge.hotelier.listings.entity

import jakarta.persistence.*

@Entity
data class Location(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    val city: String,
    val state: String,
    val country: String,
    val zipCode: Int,
    val address: String,

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    val items: List<Item?>? = null
)
