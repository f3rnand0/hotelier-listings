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
        return if (itemDto == null) {
            ResponseEntity(ItemDto(), HttpStatus.BAD_REQUEST)
        } else {
            val item = itemsService.addItem(itemDto)
            return if (item == null) {
                ResponseEntity(ItemDto(), HttpStatus.NOT_FOUND)
            } else {
                ResponseEntity(item, HttpStatus.CREATED)
            }
        }
    }

    override fun deleteItem(id: Long): ResponseEntity<Unit> {
        itemsService.deleteItem(id)
        return ResponseEntity.ok(Unit)
    }

    override fun getItemsByHotelier(hotelierId: Long): ResponseEntity<List<ItemDto>> {
        val items = itemsService.getItemByHotelier(hotelierId)
        return if (items.isNullOrEmpty()) {
            ResponseEntity(emptyList(), HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity.ok(items)
        }
    }

    override fun getItemById(id: Long): ResponseEntity<ItemDto> {
        val item = itemsService.getItemById(id)
        return if (item.isEmpty) {
            ResponseEntity(ItemDto(), HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity.ok(item.get())
        }
    }

    override fun updateItem(id: Long, itemDto: ItemDto?): ResponseEntity<ItemDto> {
        return if (itemDto == null) {
            ResponseEntity(ItemDto(), HttpStatus.BAD_REQUEST)
        } else {
            val item = itemsService.updateItem(id, itemDto)
            return if (item == null) {
                ResponseEntity(ItemDto(), HttpStatus.NOT_FOUND)
            } else {
                ResponseEntity.ok(item)
            }
        }
    }

    override fun bookItem(id: Long): ResponseEntity<ItemDto> {
        return ResponseEntity.ok(itemsService.bookItem(id))
    }
}