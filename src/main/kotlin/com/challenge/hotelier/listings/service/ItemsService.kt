package com.challenge.hotelier.listings.service

import com.challenge.hotelier.listings.mapper.Mappers
import com.challenge.hotelier.listings.model.ItemDto
import com.challenge.hotelier.listings.repository.HotelierRepository
import com.challenge.hotelier.listings.repository.ItemRepository
import com.challenge.hotelier.listings.repository.LocationRepository
import jakarta.servlet.UnavailableException
import org.springframework.stereotype.Service
import java.sql.SQLIntegrityConstraintViolationException
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
            throw IllegalArgumentException("Parameters hotelier_id, name, rating, category, location, price, and availability must be present in request")
        } else {
            val hotelier = hotelierRepository.findById(itemDto.hotelierId!!)
            if (hotelier.isEmpty) {
                throw IllegalArgumentException("Hotelier not found")
            } else {
                item.hotelier = hotelier.get()
                val locationSaved = locationRepository.save(item.location!!)
                item.location = locationSaved
                val itemSaved = itemRepository.save(item)
                return mappers.itemToDto(itemSaved)
            }
        }
    }

    fun updateItem(id: Long, itemDto: ItemDto): ItemDto? {
        val item = mappers.itemDtoToEntity(itemDto)
        if (item == null) {
            throw IllegalArgumentException("Parameters hotelier_id, name, rating, category, location, image, reputation, price, and availability must be present in request")
        } else {
            val hotelier = hotelierRepository.findById(itemDto.hotelierId!!)
            if (hotelier.isEmpty) {
                throw IllegalArgumentException("Hotelier not found")
            } else {
                item.hotelier = hotelier.get()
                val itemFromDB = itemRepository.findById(id)
                if (itemFromDB.isEmpty) {
                    throw IllegalArgumentException("Item not found")
                } else {
                    item.id = itemFromDB.get().id
                    item.location!!.id = itemFromDB.get().location!!.id
                    locationRepository.save(item.location!!)
                    itemRepository.save(item)
                    return mappers.itemToDto(item)
                }
            }
        }
    }

    fun deleteItem(id: Long) {
        val item = itemRepository.findById(id)
        if (item.isEmpty) {
            throw IllegalArgumentException("Item not found")
        } else {
            val location = item.get().location
            val itemsAssociatedLocation = locationRepository.findById(location!!.id!!).get().items
            if (itemsAssociatedLocation!!.size > 1) {
                itemRepository.delete(item.get())
                throw SQLIntegrityConstraintViolationException("The item has a location that it's associated with other items. Only the item has been deleted")
            } else {
                itemRepository.delete(item.get())
                locationRepository.delete(location)
            }
        }
    }

    fun bookItem(id: Long): ItemDto? {
        val item = itemRepository.findById(id)
        if (item.isEmpty) {
            throw IllegalArgumentException("Item not found")
        } else {
            item.get().availability--
            if (item.get().availability < 0) {
                throw UnavailableException("The item is not available anymore")
            }
            val itemSaved = itemRepository.save(item.get())
            return mappers.itemToDto(itemSaved)
        }
    }
}