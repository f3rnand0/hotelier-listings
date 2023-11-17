package com.challenge.hotelier.listings.repository

import com.challenge.hotelier.listings.entity.Hotelier
import org.springframework.data.jpa.repository.JpaRepository

interface HotelierRepository : JpaRepository<Hotelier, Long> {

}