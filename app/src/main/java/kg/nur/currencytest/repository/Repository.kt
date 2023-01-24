package kg.nur.currencytest.repository

import kg.nur.currencytest.api.RetroFitInstance
import kg.nur.currencytest.model.get.getCurrencyConverter.ConverterModels
import kg.nur.currencytest.model.get.getCurrencyOne.CurrencyOne
import retrofit2.Response

class Repository {

    suspend fun getAllValuteRepository(from: String, to: String, api_key: String): Response<CurrencyOne> {
        return RetroFitInstance.api.getAllValute(from, to, api_key)
    }

    suspend fun getConverterRepository(from: String, to: String, amount: String, api_key: String): Response<ConverterModels> {
        return RetroFitInstance.api.getConverter(from, to, amount, api_key)
    }

}