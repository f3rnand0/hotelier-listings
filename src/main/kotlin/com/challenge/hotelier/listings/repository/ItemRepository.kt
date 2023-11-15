package com.challenge.hotelier.listings.repository

import com.challenge.hotelier.listings.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ItemRepository : JpaRepository<Item, Long> {

    //@Query("FROM Item WHERE Hotelier.hotelier_id = :hotelierId")
    //fun findByHotelier(hotelierId: Long): List<Item>
}