package com.example.mvvmusingdaggerhilt.local.response

/*data class NumberResponse()*/
data class NumberResponse(
    val found: Boolean,
    val number: Int,
    val text: String,
    val type: String
)