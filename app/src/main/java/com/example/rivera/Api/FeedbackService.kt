package com.example.rivera.Api

import android.os.Handler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedbackService {

    fun addFeedback(feedbody: Feedbody, onResult: (FeedbackResponse?) -> Unit){
        val retrofit = FeedbackObject.buildService(FeedbackApi::class.java)
        retrofit.postFeedback(feedbody).enqueue(
            object :Callback<FeedbackResponse>{
                override fun onFailure(call: Call<FeedbackResponse>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(
                    call: Call<FeedbackResponse>,
                    response: Response<FeedbackResponse>
                ) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }

            }

        )
    }

    fun addRetailerFeedback(retailerFeedbody: RetailerFeedbody, onResult: (FeedbackResponse?) -> Unit){
        val retrofit = FeedbackObject.buildService(FeedbackApi::class.java)
        retrofit.postRetailerFeedback(retailerFeedbody).enqueue(
            object :Callback<FeedbackResponse>{
                override fun onFailure(call: Call<FeedbackResponse>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(
                    call: Call<FeedbackResponse>,
                    response: Response<FeedbackResponse>
                ) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }

            }

        )
    }
}