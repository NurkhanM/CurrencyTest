package kg.nur.currencytest.ui.select

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import kg.nur.currencytest.R
import kg.nur.currencytest.`interface`.IClickListnearCurrency
import kg.nur.currencytest.`object`.UserData
import kg.nur.currencytest.`object`.UserData.CURRENCY_TWO
import kg.nur.currencytest.`object`.UserData.CURRENCY_TWO_NAME
import kg.nur.currencytest.model.test.CurrencyTest
import kotlinx.android.synthetic.main.fragment_select_currency.view.*

class SelectCurrencyTwoFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterSelectCurrency
    var arrayCurrencyTest = arrayListOf<CurrencyTest>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_currency, container, false)


        arrayCurrencyTest = arrayListOf(
            CurrencyTest("Рубль" ,"RUB"),
            CurrencyTest("Доллар" ,"USD"),
            CurrencyTest("Австралийский доллар" ,"AUD"),
            CurrencyTest("Кыргызский сом" ,"KGS"),
            CurrencyTest("Бразильский реал" ,"BRL"),
            CurrencyTest("Евро" ,"EUR")
        )

        recyclerView = view.rv_currency
        adapter = AdapterSelectCurrency(object : IClickListnearCurrency {
            override fun clickListener(pos: Int, name: String, currency: String) {
                CURRENCY_TWO_NAME = name
                CURRENCY_TWO = currency
                activity?.onBackPressed()
            }

        })

        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)


        adapter.setList(arrayCurrencyTest)



        view.nextCancel.setOnClickListener {
            activity?.onBackPressed()
        }

        return view
    }


}