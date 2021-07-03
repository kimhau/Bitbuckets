package com.kimhau.bitbuckets.mapper

import com.kimhau.bitbuckets.model.BitbucketErrorResponse
import com.skydoves.sandwich.ApiErrorModelMapper
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message

object ErrorResponseMapper : ApiErrorModelMapper<BitbucketErrorResponse> {

    override fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): BitbucketErrorResponse {
        return BitbucketErrorResponse(apiErrorResponse.statusCode.code, apiErrorResponse.message())
    }
}