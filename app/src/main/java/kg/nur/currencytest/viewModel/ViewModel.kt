package kg.nur.currencytest.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nur.currencytest.model.get.getCurrencyConverter.ConverterModels
import kg.nur.currencytest.model.get.getCurrencyOne.CurrencyOne
import kg.nur.currencytest.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel : ViewModel() {

    private val repo = Repository()


    val myAllValute: MutableLiveData<Response<CurrencyOne>> = MutableLiveData()
    val myConverter: MutableLiveData<Response<ConverterModels>> = MutableLiveData()


    fun getAllValute(from: String, to: String, api_key: String) {
        viewModelScope.launch {
            myAllValute.value = repo.getAllValuteRepository(from, to, api_key)
        }
    }
    fun getConverter(from: String, to: String, amount: String, api_key: String) {
        viewModelScope.launch {
            myConverter.value = repo.getConverterRepository(from, to, amount, api_key)
        }
    }


}