package com.creativeitinstitute.ecomplatzi2402.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.creativeitinstitute.ecomplatzi2402.data.models.login.RequestLogin
import com.creativeitinstitute.ecomplatzi2402.data.models.login.ResponseLogin
import com.creativeitinstitute.ecomplatzi2402.data.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<ResponseLogin>>()
    val loginResponse : LiveData<Response<ResponseLogin>> = _response

    fun login(requestLogin: RequestLogin){

        viewModelScope.launch {

            _response.postValue(repository.login(requestLogin))
        }
    }
}