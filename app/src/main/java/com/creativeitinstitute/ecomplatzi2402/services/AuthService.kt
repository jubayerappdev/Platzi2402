package com.creativeitinstitute.ecomplatzi2402.services

import com.creativeitinstitute.ecomplatzi2402.data.models.login.RequestLogin
import com.creativeitinstitute.ecomplatzi2402.data.models.login.ResponseLogin
import com.creativeitinstitute.ecomplatzi2402.data.models.register.RequestRegistration
import com.creativeitinstitute.ecomplatzi2402.data.models.register.ResponseRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
   suspend fun login(@Body requestLogin: RequestLogin):Response<ResponseLogin>

    @POST("users/")
    suspend fun registration(@Body request: RequestRegistration):Response<ResponseRegistration>

}