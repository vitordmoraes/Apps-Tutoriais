package com.vitordmoraes.mvvm

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitordmoraes.mvvm.adapters.MainAdapter
import com.vitordmoraes.mvvm.databinding.ActivityMainBinding
import com.vitordmoraes.mvvm.repositories.MainRepository
import com.vitordmoraes.mvvm.rest.RetrofitService
import com.vitordmoraes.mvvm.viewModel.main.MainViewModel
import com.vitordmoraes.mvvm.viewModel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter {
        openLink(it.link)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService)))
            .get(MainViewModel::class.java)


        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()

        viewModel.liveList.observe(this, Observer { lives ->
            Log.i("Kaique", "LiveList.observer")
            adapter.setLivesList(lives)
        })

        viewModel.errorMessage.observe(this,{ message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun openLink(url: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Kaique", "onResume MainActivity")
        viewModel.getAllLives()
    }
}