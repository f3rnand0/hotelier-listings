package com.challenge.hotelier.listings.service

import com.challenge.hotelier.listings.entity.Hotelier
import com.challenge.hotelier.listings.entity.Item
import com.challenge.hotelier.listings.mapper.Mappers
import com.challenge.hotelier.listings.model.ItemDto
import com.challenge.hotelier.listings.repository.HotelierRepository
import com.challenge.hotelier.listings.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemsService(val itemRepository: ItemRepository, val hotelierRepository: HotelierRepository) {

    fun getItemByHotelier(hotelierId: Long): List<ItemDto> {
        return hotelierRepository.findById(hotelierId).get().items?.mapNotNull { it -> it?.let { it1 ->
            Mappers().itemtoDto(
                it1
            )
        } }!!
    }

}