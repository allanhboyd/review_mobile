package com.example.rivera.Api

data class Feedbody(
    val name:String?="",
    val phone_number:Int?=0,
    val service:String,
    val complain:String,
    val improve_area:String,
    val org_id:Int
)