package com.creativeitinstitute.ecomplatzi2402.data.repositories

import com.creativeitinstitute.ecomplatzi2402.data.models.login.RequestLogin
import com.creativeitinstitute.ecomplatzi2402.data.models.login.ResponseLogin
import com.creativeitinstitute.ecomplatzi2402.data.models.register.RequestRegistration
import com.creativeitinstitute.ecomplatzi2402.data.models.register.ResponseRegistration
import com.creativeitinstitute.ecomplatzi2402.services.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val service:AuthService){

   suspend fun login(requestLogin: RequestLogin):Response<ResponseLogin>{


       return service.login(requestLogin)
    }

    suspend fun registration(request: RequestRegistration):Response<ResponseRegistration>{


        return service.registration(request)
    }


}