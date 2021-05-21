package com.example.rivera.Api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface FeedbackApi {

    @Headers("Content-Type: application/json")
    @POST("feedback")
    fun postFeedback(@Body feedbody: Feedbody): Call<FeedbackResponse>

    @Headers("Content-Type: application/json")
    @POST("retailer-feedback")
    fun postRetailerFeedback(@Body retailerFeedbody: RetailerFeedbody): Call<FeedbackResponse>
}