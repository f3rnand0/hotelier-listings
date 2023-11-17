package com.challenge.hotelier.listings.entity

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "seq_PK", sequenceName = "ITEM_SEQUENCE", initialValue = 1000)
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_PK")
    var id: Long? = null,
    val name: String,
    val rating: Int,
    val category: Category,
    val image: String,
    val reputation: Int,
    val reputationBadge: ReputationBadge,
    val price: Long,
    var availability: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    var location: Location? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    var hotelier: Hotelier? = null
)
