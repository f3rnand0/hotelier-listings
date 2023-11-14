package com.challenge.hotelier.listings.controller

import com.challenge.hotelier.listings.api.ItemsApi
import com.challenge.hotelier.listings.model.ItemDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemsApiController : ItemsApi {

    override fun addItem(itemDto: ItemDto?): ResponseEntity<ItemDto> {
        return super.addItem(itemDto)
    }

    override fun deleteItem(id: Long?): ResponseEntity<ItemDto> {
        return super.deleteItem(id)
    }

    override fun getItemsByHotelier(hotelierId: Long?): ResponseEntity<MutableList<ItemDto>> {
        return super.getItemsByHotelier(hotelierId)
    }

    override fun getItemsById(id: Long?): ResponseEntity<ItemDto> {
        return super.getItemsById(id)
    }

    override fun updateItem(id: Long?, itemDto: ItemDto?): ResponseEntity<ItemDto> {
        return super.updateItem(id, itemDto)
    }
}