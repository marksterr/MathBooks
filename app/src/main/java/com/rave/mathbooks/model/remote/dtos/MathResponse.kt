package com.rave.mathbooks.model.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class MathResponse(
    val key: String?,
    val name: String?,
    val subject_type: String?,
    val work_count: Int?,
    val works: List<BookDTO>?
)
