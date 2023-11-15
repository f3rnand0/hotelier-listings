package com.challenge.hotelier.listings.repository

import com.challenge.hotelier.listings.entity.Hotelier
import com.challenge.hotelier.listings.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface HotelierRepository : JpaRepository<Hotelier, Long> {

}