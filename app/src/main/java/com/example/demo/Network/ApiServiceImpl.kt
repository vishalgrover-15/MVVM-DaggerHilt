package com.example.demo.Network

import com.example.demo.Model.LoginResponse
import com.example.demo.Model.PostApiResponse
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getPost(): List<PostApiResponse> = apiService.getPost()
    suspend fun login(id: String, pass: String): List<LoginResponse> =
        apiService.getLoginUserResponse(id, pass)

    suspend fun loginTestStr(id: String, pass: String): List<LoginResponse> =
        apiService.getLoginUserResponse(id, pass)
}