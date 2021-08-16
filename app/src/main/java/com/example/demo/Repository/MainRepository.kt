package com.example.demo.Repository

import com.example.demo.Model.LoginResponse
import com.example.demo.Model.PostApiResponse
import com.example.demo.Network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun getPost():Flow<List<PostApiResponse>> = flow {
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)


    /* validate login*/
    fun login(id:String, pass: String):Flow<List<LoginResponse>> = flow {
        emit(apiServiceImpl.login(id,pass))
    }.flowOn(Dispatchers.IO)



}