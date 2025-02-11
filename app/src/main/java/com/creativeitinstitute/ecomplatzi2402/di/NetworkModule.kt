package com.creativeitinstitute.ecomplatzi2402.di

import com.creativeitinstitute.ecomplatzi2402.services.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit.Builder{

         return Retrofit.Builder().baseUrl("https://api.escuelajs.co/api/v1/").addConverterFactory(
              GsonConverterFactory.create()
          )
    }

    @Provides
    @Singleton
    fun provideAuthServices(retrofit: Retrofit.Builder) : AuthService{

      return retrofit.build().create(AuthService::class.java)

    }
}