package com.kimhau.bitbuckets.network

import com.kimhau.bitbuckets.model.BitBucketResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BitbucketService {
    @GET("repositories")
    suspend fun fetchBitBucketList(
        @Query("after", encoded = true) after: String? = "1900-01-01",
    ): ApiResponse<BitBucketResponse>
}