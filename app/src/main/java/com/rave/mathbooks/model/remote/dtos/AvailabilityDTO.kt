package com.rave.mathbooks.model.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AvailabilityDTO(
    val __src__: String?,
    val available_to_borrow: Boolean?,
    val available_to_browse: Boolean?,
    val available_to_waitlist: Boolean?,
    val identifier: String?,
    val is_browseable: Boolean?,
    val is_lendable: Boolean?,
    val is_previewable: Boolean?,
    val is_printdisabled: Boolean?,
    val is_readable: Boolean?,
    val is_restricted: Boolean?,
    val isbn: String?,
    val last_loan_date: String?,
    val last_waitlist_date: String?,
    val num_waitlist: String?,
    val oclc: String?,
    val openlibrary_edition: String?,
    val openlibrary_work: String?,
    val status: String?
)
