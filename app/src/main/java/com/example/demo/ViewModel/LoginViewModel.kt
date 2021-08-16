package com.example.demo.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.Repository.MainRepository
import com.example.demo.Util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject  // providing the object of MainViewModel as injection for required clss
constructor(private val mainRepository: MainRepository) : ViewModel() {

    private var postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    val _postStateFlow: StateFlow<ApiState> = postStateFlow // this work like post() in liveData

    fun loginClicked(id: String, pass: String) = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        mainRepository.login(id, pass)
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = ApiState.LoginSuccess(data)
            }
    }
}