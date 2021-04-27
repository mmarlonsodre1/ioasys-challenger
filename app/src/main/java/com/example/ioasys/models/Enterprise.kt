package com.example.ioasys.models

import com.google.gson.annotations.SerializedName

class Enterprise(
    val id: Int? = null,
    val enterprise_name: String? = null,
    val photo: String? = null,
    val description: String? = null,
    val city: String? = null,
    val country: String? = null,
    @SerializedName("enterprise_type") val enterpriseType: EnterpriseType? = null
)

class EnterpriseType(
    val enterprise_type_name: String? = null
)