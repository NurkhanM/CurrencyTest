package kg.nur.currencytest.ui.select

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nur.currencytest.R
import kg.nur.currencytest.`interface`.IClickListnearCurrency
import kg.nur.currencytest.model.test.CurrencyTest
import kotlinx.android.synthetic.main.item_currency.view.*

class AdapterSelectCurrency(private val mIClickListnearHomeStory: IClickListnearCurrency) :
    RecyclerView.Adapter<AdapterSelectCurrency.HomeTwoViewHolder>() {
    lateinit var context: Context

    private var listHome = emptyList<CurrencyTest>()

    class HomeTwoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTwoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        context = parent.context
        return HomeTwoViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeTwoViewHolder, position: Int) {
        val currentItem = listHome[position]

        holder.itemView.itemTxtName.text = currentItem.name
        holder.itemView.itemTxtCurrency.text = currentItem.currency

        holder.itemView.rowLin.setOnClickListener {
            mIClickListnearHomeStory.clickListener(position, currentItem.name, currentItem.currency)
        }
    }

    override fun getItemCount(): Int {
        return listHome.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CurrencyTest>) {
        listHome = list
        notifyDataSetChanged()
    }
}