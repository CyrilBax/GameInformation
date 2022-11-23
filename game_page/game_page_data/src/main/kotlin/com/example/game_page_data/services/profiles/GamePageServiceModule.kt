package com.example.game_page_data.services.profiles

import com.example.business.domain.profiles.GetRawgApiKeyUseCaseModule
import com.example.business.domain.usecases.GetRawgApiKeyUseCase
import com.example.business.internal.GameInterceptor
import com.example.game_page_data.services.GamePageService
import com.example.game_page_data.services.Service
import com.example.game_page_data.services.implementations.GamePageServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module(includes = [GamePageServiceModule.ServiceModule::class, GetRawgApiKeyUseCaseModule::class])
abstract class GamePageServiceModule {

    @Binds
    abstract fun bindGamePageService(service: GamePageServiceImpl): GamePageService

    @Module
    class ServiceModule {

        @Provides
        @Named(GAME_PAGE_INTERCEPTOR)
        fun provideGameInterceptor(
            getRawgApiKeyUseCase: GetRawgApiKeyUseCase
        ): GameInterceptor = GameInterceptor(getRawgApiKeyUseCase.execute())

        @Provides
        fun provideService(@Named(GAME_PAGE_RETROFIT) retrofit: Retrofit): Service =
            retrofit.create(Service::class.java)

        @Provides
        @Named(GAME_PAGE_RETROFIT)
        fun provideRetrofit(@Named(GAME_PAGE_OKHTTP) okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        @Provides
        @Named(GAME_PAGE_OKHTTP)
        fun provideOkhttp(
            @Named(GAME_PAGE_INTERCEPTOR) gameInterceptor: GameInterceptor
        ): OkHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(gameInterceptor)
            .build()

        companion object {
            private const val BASE_URL = "https://api.rawg.io/api/"
            private const val GAME_PAGE_RETROFIT = "GAME_PAGE_RETROFIT"
            private const val GAME_PAGE_OKHTTP = "GAME_PAGE_OKHTTP"
            private const val GAME_PAGE_INTERCEPTOR = "GAME_PAGE_INTERCEPTOR"
        }


    }
}