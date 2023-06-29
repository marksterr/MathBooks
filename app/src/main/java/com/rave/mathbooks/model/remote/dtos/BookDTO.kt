package com.rave.mathbooks.model.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class BookDTO(
    val authors: List<AuthorDTO>?,
    val availability: AvailabilityDTO?,
    val cover_edition_key: String?,
    val cover_id: Int?,
    val edition_count: Int?,
    val first_publish_year: Int?,
    val has_fulltext: Boolean?,
    val ia: String?,
    val ia_collection: List<String>?,
    val key: String?,
    val lending_edition: String?,
    val lending_identifier: String?,
    val lendinglibrary: Boolean?,
    val printdisabled: Boolean?,
    val public_scan: Boolean?,
    val subject: List<String>?,
    val title: String?
)
