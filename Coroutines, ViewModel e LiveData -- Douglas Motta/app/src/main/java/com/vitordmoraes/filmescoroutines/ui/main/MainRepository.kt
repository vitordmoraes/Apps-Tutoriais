package com.vitordmoraes.filmescoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {


    fun getFilmes(callback: (filmes: List<Filme>) -> Unit){
    Thread(Runnable {
        Thread.sleep(3000)
        callback.invoke(
                listOf(
                        Filme(1, "E o vento Levou"),
                        Filme(2, "uableble")
                )
        )
    }).start()
    }

    suspend fun getFilmesCoroutines() :List<Filme> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                    Filme(1, "E o vento Levou"),
                    Filme(2, "uableble")
            )
        }
    }
}