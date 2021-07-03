package com.kimhau.bitbuckets.ui.main

import androidx.annotation.MainThread
import androidx.databinding.Bindable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.kimhau.bitbuckets.model.Bitbucket
import com.kimhau.bitbuckets.repository.MainRepository
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import com.skydoves.whatif.whatIfNotNullOrEmpty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : BindingViewModel() {
    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

    @get:Bindable
    var next: String? by bindingProperty(null)
        private set

    private val bitbucketFetchingAfterValue: MutableStateFlow<String?> = MutableStateFlow("1900-01-01")
    private val bitbucketListFlow = bitbucketFetchingAfterValue.flatMapLatest { after ->
        mainRepository.fetchBitbucketList(
            previousList = if(after.equals("1900-01-01")) emptyList() else bitBucketList,
            after = after,
            onStart = { isLoading = true },
            onComplete = {
                isLoading = false
                next = it
                         },
            onError = { toastMessage = it }
        )
    }

    @get:Bindable
    val bitBucketList: List<Bitbucket> by bitbucketListFlow.asBindingProperty(viewModelScope, emptyList())

    init {
        print("init MainViewModel")
    }

    @MainThread
    fun fetchNextBitbucketList() {
        if (!isLoading) {
            next.whatIfNotNullOrEmpty {
                val newNext = it.replace("https://api.bitbucket.org/2.0/repositories?after=","")
                bitbucketFetchingAfterValue.value = newNext
            }

        }
    }
}