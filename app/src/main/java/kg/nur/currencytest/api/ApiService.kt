package kg.nur.currencytest.api

import kg.nur.currencytest.model.get.getCurrencyConverter.ConverterModels
import kg.nur.currencytest.model.get.getCurrencyOne.CurrencyOne
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers("Accept: application/json")
    @GET("fetch-one?")
    suspend fun getAllValute(
        @Query ("from") from: String,
        @Query ("to") to: String,
        @Query ("api_key") api_key: String
    ): Response<CurrencyOne>


    @Headers("Accept: application/json")
    @GET("convert?")
    suspend fun getConverter(
        @Query ("from") from: String,
        @Query ("to") to: String,
        @Query ("amount") amount: String,
        @Query ("api_key") api_key: String
    ): Response<ConverterModels>


}