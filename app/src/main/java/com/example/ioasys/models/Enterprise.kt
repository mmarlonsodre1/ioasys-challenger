package com.example.ioasys.models

import com.google.gson.annotations.SerializedName

class Enterprise(
    val id: Int? = null,
    @SerializedName("enterprise_name") val enterpriseName: String? = null,
    val photo: String? = null,
    val description: String? = null,
    val city: String? = null,
    val country: String? = null,
    @SerializedName("enterprise_type") val enterpriseType: EnterpriseType? = null
)

class EnterpriseType(
        @SerializedName("enterprise_type_name") val enterpriseTypeName: String? = null
)