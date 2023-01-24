package kg.nur.currencytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                disconnect.visibility = View.GONE
                connect.visibility = View.VISIBLE
            } else {
                disconnect.visibility = View.VISIBLE
                connect.visibility = View.GONE
            }
        }


    }
}