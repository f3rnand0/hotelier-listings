package com.challenge.hotelier.listings.repository

import com.challenge.hotelier.listings.entity.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long> {

}