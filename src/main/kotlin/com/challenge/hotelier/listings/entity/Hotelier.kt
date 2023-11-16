package com.challenge.hotelier.listings.entity

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "seq_PK", sequenceName = "HOTELIER_SEQUENCE", initialValue = 1000, allocationSize = 10)
data class Hotelier(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_PK")
    var id: Long? = null,
    @Column(name="first_name")
    val firstName: String,
    @Column(name="last_name")
    val lastName: String,

    @OneToMany(mappedBy = "hotelier", fetch = FetchType.LAZY)
    val items: List<Item?>? = null
)
