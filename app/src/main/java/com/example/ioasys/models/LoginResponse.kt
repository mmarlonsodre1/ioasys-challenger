package com.example.ioasys.models

import okhttp3.Headers

class LoginResponse(
    val investor : Investor? = null,
    val success: Boolean = false,
    var headers: Headers? = null
)