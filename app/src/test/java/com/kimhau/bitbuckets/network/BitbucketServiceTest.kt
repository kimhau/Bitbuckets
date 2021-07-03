package com.kimhau.bitbuckets.network

import com.kimhau.bitbuckets.MainCoroutinesRule
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNull.nullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class BitbucketServiceTest : ApiAbstract<BitbucketService>() {

    private lateinit var service: BitbucketService

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @Before
    fun initService() {
        service = createService(BitbucketService::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun fetchBitbucketListFromNetworkTest() = runBlocking {
        enqueueResponse("/BitbucketResponse.json")
        val response = service.fetchBitBucketList()
        val responseBody = requireNotNull((response as ApiResponse.Success).data)
        mockWebServer.takeRequest()

        assertThat(responseBody.pagelen, `is`(10))
        assertThat(responseBody.values!![0].name, `is`("xwork"))
        assertThat(responseBody.next, `is`("https://api.bitbucket.org/2.0/repositories?after=2011-09-03T12%3A33%3A16.028393%2B00%3A00"))
    }

    @Throws(IOException::class)
    @Test
    fun fetchModifiedBitbucketListFromNetworkTest() = runBlocking {
        enqueueResponse("/ModifiedBitbucketResponse.json")
        val response = service.fetchBitBucketList()
        val responseBody = requireNotNull((response as ApiResponse.Success).data)
        mockWebServer.takeRequest()

        assertThat(responseBody.pagelen, `is`(10))
        assertThat(responseBody.values!![0].name, `is`(nullValue()))
        assertThat(responseBody.next, `is`(nullValue()))
    }

}