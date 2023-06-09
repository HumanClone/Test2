package com.example.test2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Start : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        auth = Firebase.auth
    }

    fun login(view:View)
    {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    fun signup(view:View)
    {
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }
}