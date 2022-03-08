package com.exchanger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.exchanger.R.layout
import com.exchanger.utils.Constants.Companion.API_KEY
import com.exchanger.utils.NetworkResult
import com.exchanger.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        initViewModel()
        requestApiData()
    }


    private fun requestApiData(){

        val rate: HashMap<String, String> = HashMap()
        rate["access_key"] = API_KEY
        mainViewModel.getRate(rate)
        mainViewModel.rateResponse.observe(this) {response ->

         when (response){
             is NetworkResult.Success ->{

             }
             is NetworkResult.Error ->{
                Toast.makeText(
                    this,
                    response.message.toString(),
                    Toast.LENGTH_LONG
                ).show()
             }
             is NetworkResult.Loading ->{

             }
         }
        }
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}