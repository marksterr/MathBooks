package com.rave.mathbooks.model

import com.rave.mathbooks.model.local.Book
import com.rave.mathbooks.model.remote.APIService
import javax.inject.Inject

/**
 * Math repo.
 *
 * @property service
 * @constructor Create empty Math repo
 */
class MathRepo @Inject constructor(private val service: APIService) {

    /**
     * Get math books.
     *
     * @return
     */
    suspend fun getMathBooks(): List<Book> {
        val bookDTOs = service.getMathBooks().works
        return bookDTOs!!.map {
            Book(
                title = it.title!!
            )
        }
    }
}
