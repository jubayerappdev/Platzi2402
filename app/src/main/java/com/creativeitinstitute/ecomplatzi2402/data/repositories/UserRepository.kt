package com.creativeitinstitute.ecomplatzi2402.data.repositories

import com.creativeitinstitute.ecomplatzi2402.data.models.profile.ResponseProfile
import com.creativeitinstitute.ecomplatzi2402.services.UserService
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val service:UserService){

   suspend fun profile():Response<ResponseProfile>{


       return service.profile()
    }


}