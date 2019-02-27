package com.viseo.githubdashboard.di.modules

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.viseo.githubdashboard.BaseApp
import com.viseo.githubdashboard.BuildConfig
import com.viseo.githubdashboard.network.GithubServices
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

@Module
object NetworkingModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideGithubServices(retrofit: Retrofit): GithubServices =
        retrofit.create(GithubServices::class.java)

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideCache(): Cache {
        val httpCacheDirectory = File(BaseApp.instance.cacheDir, "http-cache")
        val cacheSize = 10 * 1024 * 1024 // 10 MiB of cache
        return Cache(httpCacheDirectory, cacheSize.toLong())
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor { chain ->
                val response = chain.proceed(chain.request())
                val cacheControl = CacheControl.Builder()
                    .maxAge(60, TimeUnit.MINUTES) // 1 hour cache
                    .build()

                response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", cacheControl.toString())
                    .build()
            }
            .cache(cache)
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}