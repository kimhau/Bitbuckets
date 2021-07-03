package com.kimhau.bitbuckets.di

import com.kimhau.bitbuckets.network.BitbucketClient
import com.kimhau.bitbuckets.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        bitBucketClient: BitbucketClient,
        coroutineDispatcher: CoroutineDispatcher
    ): MainRepository {
        return MainRepository(bitBucketClient, coroutineDispatcher)
    }
}