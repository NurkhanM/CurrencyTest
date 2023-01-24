package kg.nur.currencytest.ui.currency

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import kg.nur.currencytest.R
import kg.nur.currencytest.`object`.UserData.API_CURRENCY
import kg.nur.currencytest.`object`.UserData.CURRENCY_FIRST
import kg.nur.currencytest.`object`.UserData.CURRENCY_FIRST_NAME
import kg.nur.currencytest.`object`.UserData.CURRENCY_TWO
import kg.nur.currencytest.`object`.UserData.CURRENCY_TWO_NAME
import kg.nur.currencytest.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_currency.view.*

class Currency : Fragment() {

    private lateinit var viewModels: ViewModel
    lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModels = ViewModelProvider(this)[ViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_currency, container, false)


        getInfoResult()

        dialog = Dialog(requireContext())

        view.nextChange.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_Currency_to_selectCurrencyFragment)

        }

        view.nextChange2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_Currency_to_selectCurrencyTwoFragment)
        }

        viewModels.myAllValute.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {

                view?.txtDateCur?.text = list.body()?.updated
                view?.txtNameCur1?.text = CURRENCY_FIRST_NAME
                view?.txtNameCur2?.text = CURRENCY_TWO_NAME
                view?.txtNumCur1?.text = "1"

                if (list.body()?.result?.RUB != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.RUB.toString()
                }
                if (list.body()?.result?.AUD != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.AUD.toString()
                }
                if (list.body()?.result?.BRL != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.BRL.toString()
                }
                if (list.body()?.result?.EUR != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.EUR.toString()
                }
                if (list.body()?.result?.USD != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.USD.toString()
                }

                if (list.body()?.result?.KGS != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.KGS.toString()
                }

            } else {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        }

        view.txtNumCur1.setOnClickListener {
            dialogCurrentChange()
        }
        view.txtNumCur2.setOnClickListener {
            dialogCurrentChange2()
        }


        return view

    }

    fun getInfoResult() {

        viewModels.getAllValute(CURRENCY_FIRST, CURRENCY_TWO, API_CURRENCY)

    }

    private fun dialogCurrentChange() {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_current_change)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog.findViewById<Button>(R.id.dialog_save)
        val exit = dialog.findViewById<ImageView>(R.id.imgCancel)
        val textCurrency = dialog.findViewById<EditText>(R.id.edt_currency)
        buttonYES.setOnClickListener {
            view?.txtNumCur1?.text = textCurrency.text
            converterInfo(textCurrency.text.toString())
            dialog.dismiss()
        }
        exit.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

    private fun dialogCurrentChange2() {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_current_change)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog.findViewById<Button>(R.id.dialog_save)
        val exit = dialog.findViewById<ImageView>(R.id.imgCancel)
        val textCurrency = dialog.findViewById<EditText>(R.id.edt_currency)
        buttonYES.setOnClickListener {
            view?.txtNumCur2?.text = textCurrency.text
            converterInfo2(textCurrency.text.toString())
            dialog.dismiss()
        }
        exit.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }


    fun converterInfo(amount: String) {
        viewModels.getConverter(CURRENCY_FIRST, CURRENCY_TWO, amount, API_CURRENCY)

        viewModels.myConverter.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {

                if (list.body()?.result?.RUB != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.RUB.toString()
                }
                if (list.body()?.result?.AUD != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.AUD.toString()
                }
                if (list.body()?.result?.BRL != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.BRL.toString()
                }
                if (list.body()?.result?.EUR != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.EUR.toString()
                }
                if (list.body()?.result?.USD != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.USD.toString()
                }

                if (list.body()?.result?.KGS != null) {
                    view?.txtNumCur2?.text = list.body()?.result?.KGS.toString()
                }

            }

        }
    }

    fun converterInfo2(amount: String) {
        viewModels.getConverter(CURRENCY_TWO, CURRENCY_FIRST, amount, API_CURRENCY)

        viewModels.myConverter.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {

                if (list.body()?.result?.RUB != null) {
                    view?.txtNumCur1?.text = list.body()?.result?.RUB.toString()
                }
                if (list.body()?.result?.AUD != null) {
                    view?.txtNumCur1?.text = list.body()?.result?.AUD.toString()
                }
                if (list.body()?.result?.BRL != null) {
                    view?.txtNumCur1?.text = list.body()?.result?.BRL.toString()
                }
                if (list.body()?.result?.EUR != null) {
                    view?.txtNumCur1?.text = list.body()?.result?.EUR.toString()
                }
                if (list.body()?.result?.USD != null) {
                    view?.txtNumCur1?.text = list.body()?.result?.USD.toString()
                }

                if (list.body()?.result?.KGS != null) {
                    view?.txtNumCur1?.text = list.body()?.result?.KGS.toString()
                }

            }

        }
    }
}