package com.kimhau.bitbuckets.repository

import androidx.annotation.WorkerThread
import com.kimhau.bitbuckets.mapper.ErrorResponseMapper
import com.kimhau.bitbuckets.model.Bitbucket
import com.kimhau.bitbuckets.network.BitbucketClient
import com.skydoves.sandwich.map
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val bitBucketClient: BitbucketClient,
    private val ioDispatcher: CoroutineDispatcher
) {
    var next: String? = null;

    @WorkerThread
    fun fetchBitbucketList(
        previousList: List<Bitbucket>,
        after: String?,
        onStart: () -> Unit,
        onComplete: (String?) -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        val bitbuckets = arrayListOf<Bitbucket>()
        previousList.whatIfNotNullOrEmpty{
            bitbuckets.addAll(it)
        }
        next = null;
        val response = bitBucketClient.fetchBitBucketList(after = after)
        response.suspendOnSuccess {
            data.whatIfNotNull {
                it.values.whatIfNotNullOrEmpty { list ->
                    bitbuckets.addAll(list)
                }

                next = it.next
                emit(bitbuckets)
            }
        }

            .onError {
                map(ErrorResponseMapper) { onError("[Code: $code]: $message") }
            }
            .onException { onError(message) }
    }.onStart { onStart() }
        .onCompletion {  onComplete(next) }
        .flowOn(ioDispatcher)
}