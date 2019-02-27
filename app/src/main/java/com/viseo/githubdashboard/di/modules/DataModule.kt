package com.viseo.githubdashboard.di.modules

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object DataModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideGson() = GsonBuilder()
        .setLenient()
        .serializeNulls()
        .create()
}