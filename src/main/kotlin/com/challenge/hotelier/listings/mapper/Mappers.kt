package com.challenge.hotelier.listings.mapper

import com.challenge.hotelier.listings.entity.Item
import com.challenge.hotelier.listings.entity.Location
import com.challenge.hotelier.listings.model.ItemDto
import com.challenge.hotelier.listings.model.LocationDto
import com.challenge.hotelier.listings.validator.Validators

class Mappers {

    private val validator = Validators()

    fun itemToDto(item: Item): ItemDto {
        return ItemDto(
            item.hotelier?.id,
            item.name,
            item.rating,
            item.category.value,
            locationToDto(item.location),
            item.image,
            item.reputation,
            item.reputationBadge.value,
            item.price,
            item.availability
        )
    }

    fun itemDtoToEntity(itemDto: ItemDto): Item? {
        if (itemDto.hotelierId == null || itemDto.name == null || itemDto.rating == null || itemDto.category == null || itemDto.location == null || itemDto.image == null || itemDto.reputation == null || itemDto.price == null || itemDto.availability == null) {
            return null
        } else {
            return Item(
                null,
                validator.validateName(itemDto.name),
                validator.validateRating(itemDto.rating),
                validator.validateCategory(itemDto.category),
                validator.validatePath(itemDto.image),
                validator.validateReputation(itemDto.reputation),
                validator.generateReputationBadge(itemDto.reputation),
                itemDto.price,
                itemDto.availability,
                locationDtoEntity(itemDto.location),
            )
        }
    }

    private fun locationToDto(location: Location?): LocationDto {
        var locationDto = LocationDto()
        if (location != null) {
            locationDto = LocationDto(
                location.city,
                location.state,
                location.country,
                validator.validateZipCode(location.zipCode),
                location.address
            )
        }
        return locationDto
    }

    private fun locationDtoEntity(locationDto: LocationDto): Location {
        return Location(
            null,
            locationDto.city!!,
            locationDto.state!!,
            locationDto.country!!,
            locationDto.zipCode!!,
            locationDto.address!!
        )
    }
}