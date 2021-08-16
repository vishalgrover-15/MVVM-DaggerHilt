package com.example.demo.Util

import com.example.demo.Model.LoginResponse
import com.example.demo.Model.PostApiResponse

sealed class ApiState {
    object Loading : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    class Success(val data: List<PostApiResponse>) : ApiState()
    class LoginSuccess(val data: List<LoginResponse>) : ApiState()
    object Empty : ApiState()
}
