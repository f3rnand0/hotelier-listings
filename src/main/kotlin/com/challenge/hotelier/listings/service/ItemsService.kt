package com.challenge.hotelier.listings.service

import com.challenge.hotelier.listings.exceptions.IllegalHotelierException
import com.challenge.hotelier.listings.mapper.Mappers
import com.challenge.hotelier.listings.model.ItemDto
import com.challenge.hotelier.listings.repository.HotelierRepository
import com.challenge.hotelier.listings.repository.ItemRepository
import com.challenge.hotelier.listings.repository.LocationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ItemsService(
    val itemRepository: ItemRepository,
    val hotelierRepository: HotelierRepository,
    val locationRepository: LocationRepository
) {

    val mappers = Mappers()
    fun getItemByHotelier(hotelierId: Long): List<ItemDto> {
        return hotelierRepository.findById(hotelierId).get().items?.mapNotNull {
            it?.let { it1 ->
                mappers.itemToDto(
                    it1
                )
            }
        }!!
    }

    fun getItemById(id: Long): Optional<ItemDto> {
        return itemRepository.findById(id).map { it -> mappers.itemToDto(it) }
    }

    fun addItem(itemDto: ItemDto): ItemDto? {
        val item = mappers.itemDtoToEntity(itemDto)
        if (item == null) {
            throw IllegalArgumentException("Parameters name, rating, category, price, or availability must be present in request")
        } else {
            val hotelier = hotelierRepository.findById(itemDto.hotelierId)
            if (hotelier.isEmpty) {
                throw IllegalHotelierException("Hotelier not found")
            } else {
                item.hotelier = hotelier.get()
                val locationSaved = locationRepository.save(item.location)
                item.location = locationSaved
                val itemSaved = itemRepository.save(item)
                return mappers.itemToDto(itemSaved)
            }
        }
    }

}