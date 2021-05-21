package com.example.rivera.Api

data class RetailerFeedbody(
    val price_rate: String ="",
    val quality_rate:String?="",
    val store_rate:String?="",
    val access_rate:String?="",
    val recommend_rate:String?="",
    val org_id:Int,
    val areas:String?="",
    val stock:String?="",
    val source:String?=""
)