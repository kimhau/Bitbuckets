package com.kimhau.bitbuckets.network

import com.kimhau.bitbuckets.model.BitBucketResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class BitBucketClient @Inject constructor(
    private val bitbucketService: BitbucketService
) {

    suspend fun fetchBitBucketList(
        after: String?
    ): ApiResponse<BitBucketResponse> =
        bitbucketService.fetchBitBucketList(
            after = after
        )
}