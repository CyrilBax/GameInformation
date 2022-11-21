package com.example.game_list_data.sources.profiles

import com.example.business.domain.profiles.GetRawgApiKeyUseCaseModule
import com.example.business.domain.usecases.GetRawgApiKeyUseCase
import com.example.business.internal.GameInterceptor
import com.example.game_list_data.sources.GameListSource
import com.example.game_list_data.sources.Source
import com.example.game_list_data.sources.implementations.GameListSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module(includes = [GameListSourceModule.ServiceModule::class, GetRawgApiKeyUseCaseModule::class])
abstract class GameListSourceModule {

    @Binds
    abstract fun bindGameListSource(source: GameListSourceImpl): GameListSource

    @Module
    class ServiceModule {

        @Provides
        @Named(GAME_INTERCEPTOR)
        fun provideGameInterceptor(
            getRawgApiKeyUseCase: GetRawgApiKeyUseCase
        ): GameInterceptor = GameInterceptor(getRawgApiKeyUseCase.execute())

        @Provides
        fun provideService(@Named(GAME_RETROFIT) retrofit: Retrofit): Source =
            retrofit.create(Source::class.java)

        @Provides
        @Named(GAME_RETROFIT)
        fun provideRetrofit(@Named(GAME_OKHTTP) okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        @Provides
        @Named(GAME_OKHTTP)
        fun provideOkhttp(
            @Named(GAME_INTERCEPTOR) gameInterceptor: GameInterceptor
        ): OkHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(gameInterceptor)
            .build()

        companion object {
            private const val BASE_URL = "https://api.rawg.io/api/"
            private const val GAME_RETROFIT = "GAME_RETROFIT"
            private const val GAME_OKHTTP = "GAME_OKHTTP"
            private const val GAME_INTERCEPTOR = "GAME_INTERCEPTOR"
        }

    }
}