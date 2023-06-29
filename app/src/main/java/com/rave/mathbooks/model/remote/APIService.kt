package com.rave.mathbooks.model.remote

import com.rave.mathbooks.model.remote.dtos.MathResponse
import retrofit2.http.GET

/**
 * Api service to connect to endpoints.
 *
 * @constructor Create empty A p i service
 */
interface APIService {

    @GET("subjects/math.json")
    suspend fun getMathBooks(): MathResponse
}
