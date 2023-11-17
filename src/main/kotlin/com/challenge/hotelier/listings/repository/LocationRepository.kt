package com.challenge.hotelier.listings.repository

import com.challenge.hotelier.listings.entity.Location
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<Location, Long> {

}