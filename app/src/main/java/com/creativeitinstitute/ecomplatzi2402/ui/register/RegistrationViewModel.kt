package com.creativeitinstitute.ecomplatzi2402.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.creativeitinstitute.ecomplatzi2402.data.models.register.RequestRegistration
import com.creativeitinstitute.ecomplatzi2402.data.models.register.ResponseRegistration
import com.creativeitinstitute.ecomplatzi2402.data.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<ResponseRegistration>>()
    val registrationResponse : LiveData<Response<ResponseRegistration>> = _response

    fun registration(request: RequestRegistration){

        viewModelScope.launch {

            _response.postValue(repository.registration(request))
        }
    }
}