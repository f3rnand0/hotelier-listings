package com.challenge.hotelier.listings.repository

import com.challenge.hotelier.listings.entity.Item
import com.challenge.hotelier.listings.entity.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface LocationRepository : JpaRepository<Location, Long> {
}