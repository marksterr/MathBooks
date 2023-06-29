package com.rave.mathbooks.model.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AuthorDTO(
    val key: String?,
    val name: String?
)
