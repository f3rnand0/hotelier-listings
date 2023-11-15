package com.challenge.hotelier.listings.mapper

import com.challenge.hotelier.listings.entity.Item
import com.challenge.hotelier.listings.entity.Location
import com.challenge.hotelier.listings.model.ItemDto
import com.challenge.hotelier.listings.model.LocationDto

class Mappers {

    fun itemtoDto(item: Item): ItemDto {
        return ItemDto(
            item.hotelier?.id,
            item.name,
            item.rating,
            item.category,
            locationToDto(item.location),
            item.image,
            item.reputation,
            item.reputationBadge,
            item.price,
            item.availability
        )
    }

    fun locationToDto(location: Location?): LocationDto {
        var locationDto = LocationDto()
        if (location != null) {
            locationDto = LocationDto(
                location.city,
                location.state,
                location.country,
                location.zipCode,
                location.address
            )
        }
        return locationDto
    }

}