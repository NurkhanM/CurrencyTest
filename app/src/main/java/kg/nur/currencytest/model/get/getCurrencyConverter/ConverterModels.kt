package kg.nur.currencytest.model.get.getCurrencyConverter

data class ConverterModels(
    val amount: Int,
    val base: String,
    val ms: Int,
    val result: Result
)