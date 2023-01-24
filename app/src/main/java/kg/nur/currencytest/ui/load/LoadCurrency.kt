package kg.nur.currencytest.ui.load

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kg.nur.currencytest.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadCurrency : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_load_currency, container, false)


        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            Navigation.findNavController(view)
                .navigate(R.id.action_LoadCurrency_to_Currency)
        }


        return view
    }

}