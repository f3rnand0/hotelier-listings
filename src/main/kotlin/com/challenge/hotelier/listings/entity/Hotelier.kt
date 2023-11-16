package com.challenge.hotelier.listings.entity

import jakarta.persistence.*

@Entity
data class Hotelier(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    @Column(name="first_name")
    val firstName: String,
    @Column(name="last_name")
    val lastName: String,

    @OneToMany(mappedBy = "hotelier", fetch = FetchType.LAZY)
    val items: List<Item?>? = null
)
