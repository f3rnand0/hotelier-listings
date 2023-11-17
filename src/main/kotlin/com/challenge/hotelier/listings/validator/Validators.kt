package com.challenge.hotelier.listings.validator

import com.challenge.hotelier.listings.entity.Category
import com.challenge.hotelier.listings.entity.ReputationBadge
import org.apache.commons.lang3.StringUtils
import java.nio.file.Paths

class Validators {

    private val invalidSubNames = setOf("Free", "Offer", "Book", "Website")
    private val categories =
        setOf("hotel", "alternative", "hostel", "lodge", "resort", "guesthouse")

    fun validateName(name: String): String {
        val invalidNamesCount = invalidSubNames.stream().filter { i -> StringUtils.containsIgnoreCase(
            name, i) }.count()
        return if (invalidNamesCount > 0 || name.length <= 10) {
            throw IllegalArgumentException("Name must no contain the following words (in any case): Free, Offer, Book, Website; and must be longer than 10 characters")
        } else {
            name
        }
    }

    fun validateRating(rating: Int): Int {
        return if (rating !in 0..5) {
            throw IllegalArgumentException("Rating must be above or equal to 0 and less than or equal to 5")
        } else {
            rating
        }
    }

    fun validateCategory(category: String): Category {
        return if (!categories.contains(category)) {
            throw IllegalArgumentException("Category must be one of the following values [hotel, alternative, hostel, lodge, resort, guesthouse")
        } else {
            Category.valueOf(category)
        }
    }

    fun validateReputation(reputation: Int): Int {
        return if (reputation !in 0..1000) {
            throw IllegalArgumentException("Reputation must be above or equal to 0 and less than or equal to 1000")
        } else {
            reputation
        }
    }

    fun generateReputationBadge(reputation: Int): ReputationBadge {
        return when (reputation) {
            in 0..500 -> {
                ReputationBadge.red
            }
            in 501..799 -> {
                ReputationBadge.yellow
            }
            in 800..1000 -> {
                ReputationBadge.green
            }
            else -> {
                throw IllegalArgumentException("Reputation must be above or equal to 0 and less than or equal to 1000")
            }
        }
    }

    fun validatePath(url: String?): String {
        return if (url == null) {
            throw java.lang.IllegalArgumentException("The image must be present")
        } else {
            Paths.get(url).toString()
        }
    }

    fun validateZipCode(zipCode: Int): Int {
        return if (zipCode.toString().length != 5) {
            throw IllegalArgumentException("Zip code must be a value of exactly 5 integers")
        } else {
            zipCode
        }
    }
}