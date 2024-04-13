package com.example.helloweather.di

import android.content.Context
import com.example.fooddeliverygosport.di.interceptors.OfflineInterceptor
import com.example.fooddeliverygosport.di.interceptors.OnlineInterceptor
import com.example.helloweather.common.Constants
import com.example.helloweather.data.remote.retrofit.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        @ApplicationContext context: Context,
        onlineInterceptor: OnlineInterceptor,
        offlineInterceptor: OfflineInterceptor
    ): OkHttpClient {
        val cacheSize = (5 * 1024 * 1024).toLong() // 5 MB
        val cacheDir = File(context.cacheDir, "http-cache")
        val cache = Cache(cacheDir, cacheSize)

        return OkHttpClient.Builder()
            .cache(cache)
            .addNetworkInterceptor(onlineInterceptor)
            .addInterceptor(offlineInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitCategories(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun provideMealDbApiProduct(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

}