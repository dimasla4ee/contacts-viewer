package io.dimasla4ee.contacts_viewer.domain.model

import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val surname: String? = null,
    val familyName: String,
    @param:DrawableRes val imageRes: Int? = null,
    val isFavorite: Boolean = false,
    val phone: String,
    val address: String,
    val email: String? = null
)