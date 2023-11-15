package com.challenge.hotelier.listings.controller

import com.challenge.hotelier.listings.api.ItemsApi
import com.challenge.hotelier.listings.model.ItemDto
import com.challenge.hotelier.listings.service.ItemsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemsApiController(val itemsService: ItemsService) : ItemsApi {

    override fun addItem(itemDto: ItemDto?): ResponseEntity<ItemDto> {
        return super.addItem(itemDto)
    }

    override fun deleteItem(id: Long): ResponseEntity<ItemDto> {
        return super.deleteItem(id)
    }

    override fun getItemsByHotelier(hotelierId: Long): ResponseEntity<List<ItemDto>> {
        val items = itemsService.getItemByHotelier(hotelierId)
        if (items.isEmpty()) {
            return ResponseEntity(emptyList<ItemDto>(), HttpStatus.NOT_FOUND)
        } else {
            return ResponseEntity.ok(items)
        }
    }

    override fun getItemsById(id: Long): ResponseEntity<ItemDto> {
        return super.getItemsById(id)
    }

    override fun updateItem(id: Long, itemDto: ItemDto?): ResponseEntity<ItemDto> {
        return super.updateItem(id, itemDto)
    }
}