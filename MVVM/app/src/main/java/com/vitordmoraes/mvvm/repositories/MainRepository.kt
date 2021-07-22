package com.vitordmoraes.mvvm.repositories

import com.vitordmoraes.mvvm.rest.RetrofitService

class MainRepository (private val retrofitService: RetrofitService){

    fun getAllLives() = retrofitService.getAllLives()

}