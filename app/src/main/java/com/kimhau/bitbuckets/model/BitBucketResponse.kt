package com.kimhau.bitbuckets.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BitBucketResponse(
    @Json(name = "next")
    val next: String?,
    @Json(name = "pagelen")
    val pagelen: Int?,
    @Json(name = "values")
    val values: List<Bitbucket>?
) 
