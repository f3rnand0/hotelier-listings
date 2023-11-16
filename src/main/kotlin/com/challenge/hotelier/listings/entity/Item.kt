package com.challenge.hotelier.listings.entity

import com.challenge.hotelier.listings.model.ItemDto.Category
import com.challenge.hotelier.listings.model.ItemDto.ReputationBadge
import jakarta.persistence.*

@Entity
class Item(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    val name: String,
    val rating: Int,
    val category: Category,
    val image: String,
    val reputation: Int,
    val reputationBadge: ReputationBadge,
    val price: Long,
    val availability: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    var location: Location? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    var hotelier: Hotelier? = null


)
