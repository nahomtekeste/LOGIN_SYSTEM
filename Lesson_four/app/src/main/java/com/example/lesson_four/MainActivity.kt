package com.example.lesson_four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {

   lateinit var handle :DateBaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handle = DateBaseHelper(this)

        showHome()

        registration.setOnClickListener() {
            showregistration()
        }
        login.setOnClickListener() {
            showLogin()
        }
        sava.setOnClickListener {
            handle.inserUserData(name.text.toString(), email.text.toString(), password.text.toString())
            showHome()

        }
        btn_login.setOnClickListener() {
            if (handle.userPresent(txt_login_email.text.toString(), txt_login_password.text.toString()))
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this , "User or Password is not Correct " , Toast.LENGTH_SHORT).show()

        }

    }
    private fun showregistration(){
        registration.visibility = View.VISIBLE
        login.visibility = View.GONE
        home_11.visibility = View.GONE

    }
    private fun showLogin(){
        registration.visibility = View.VISIBLE
        login.visibility = View.GONE
        home_11.visibility = View.GONE
    }
    private fun showHome(){
        registration.visibility = View.VISIBLE
        login.visibility = View.GONE
        home_11.visibility = View.GONE
    }

}



