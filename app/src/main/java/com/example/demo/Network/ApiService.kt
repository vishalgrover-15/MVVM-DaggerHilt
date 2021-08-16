package com.example.demo.Network

import com.example.demo.Model.LoginResponse
import com.example.demo.Model.PostApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("posts")
   suspend fun getPost():List<PostApiResponse>

    @GET("users")
    suspend fun getLoginUserResponse(@Query("id") id: String, @Query("pass") pass: String):List<LoginResponse>
}