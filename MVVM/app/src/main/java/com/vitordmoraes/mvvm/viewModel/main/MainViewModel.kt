package com.vitordmoraes.mvvm.viewModel.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitordmoraes.mvvm.model.Live
import com.vitordmoraes.mvvm.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives(){
        val request = repository.getAllLives()
        request.enqueue(object : Callback<List<Live>> {
            override fun onResponse(call: Call<List<Live>>, response: Response<List<Live>>) {
                //Quando houver uma resposta
                Log.i("Kaique", "onResponse")
                liveList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Live>>, t: Throwable) {
                //Quando houver uma falha
                errorMessage.postValue(t.message)
            }
        })


    }
}