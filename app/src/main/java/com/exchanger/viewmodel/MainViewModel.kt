package com.exchanger.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Telephony.Mms.Rate
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.exchanger.data.Repository
import com.exchanger.models.ExchangeRatesModel
import com.exchanger.utils.NetworkResult
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel @ViewModelInject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    var rateResponse: MutableLiveData<NetworkResult<ExchangeRatesModel>> = MutableLiveData()

    fun getRate(rate: Map<String, String>) = viewModelScope.launch {
        getRateSafeCall(rate)
    }


    private suspend fun getRateSafeCall(rate: Map<String, String>) {

        rateResponse.value = NetworkResult.Loading()
        if (hasInternetConnection()) {
            val response = repository.remote.getRate(rate)
             rateResponse.value = handleRateResponse(response)
        } else {
            rateResponse.value = NetworkResult.Error("No Internet Connection.")
        }
    }

    private fun handleRateResponse(response: Response<ExchangeRatesModel>): NetworkResult<ExchangeRatesModel>? {

        when {
            response.message().toString().contains("timeout")->{
                return NetworkResult.Error("Timeout")
            }
            response.code() == 402 ->{
                return NetworkResult.Error("API Key Limited")
            }
            response.body()!!.rate.isEmpty()->{
                return NetworkResult.Error("Rate not found.")
            }
            response.isSuccessful ->{
                val rate = response.body()
                return NetworkResult.Success(rate)
            }
            else ->{
                return NetworkResult.Error(response.message())
            }
        }
    }

    private fun hasInternetConnection(): Boolean {

        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}