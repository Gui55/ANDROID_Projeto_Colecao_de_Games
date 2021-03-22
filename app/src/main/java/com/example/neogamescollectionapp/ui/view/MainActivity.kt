package com.example.neogamescollectionapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.neogamescollectionapp.R
import com.example.neogamescollectionapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instância da ViewModel desta View/Activity
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        observations()
    }

    fun loginAction(view: View) {
        viewModel.loginAction(editUsername.text.toString(), editPassword.text.toString())
    }

    private fun observations() {
        viewModel.resultString.observe(this, Observer {
            if(it=="Sucesso"){
                startActivity(Intent(this, HomeActivity::class.java))
                viewModel.clearResultString()
                finish()
            } else {
                if(it!=""){
                    displayMessage(it)
                }
            }
        })
    }

    fun displayMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}