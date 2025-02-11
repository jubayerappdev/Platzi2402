package com.creativeitinstitute.ecomplatzi2402.services

import com.creativeitinstitute.ecomplatzi2402.data.models.profile.ResponseProfile
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("auth/profile")
   suspend fun profile():Response<ResponseProfile>



}