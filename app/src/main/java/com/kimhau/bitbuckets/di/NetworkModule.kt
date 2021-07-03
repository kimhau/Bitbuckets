package com.kimhau.bitbuckets.di

import com.kimhau.bitbuckets.network.BitbucketClient
import com.kimhau.bitbuckets.network.BitbucketService
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.bitbucket.org/2.0/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideBitBucketService(retrofit: Retrofit): BitbucketService {
        return retrofit.create(BitbucketService::class.java)
    }

    @Provides
    @Singleton
    fun provideBitBucketClient(bitbucketService: BitbucketService): BitbucketClient {
        return BitbucketClient(bitbucketService)
    }
}