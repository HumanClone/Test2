package com.example.test2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun signup(view: View)
    {
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }

    fun back(view: View)
    {
        val intent = Intent(this, Start::class.java)
        startActivity(intent)
    }

    fun log(view: View)
    {
        //val intent = Intent(this, Main_Menu::class.java)
        val intent = Intent(this, Features ::class.java)
        startActivity(intent)
    }
}