package com.example.test2

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity()
{

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = Firebase.auth
        button_w.setOnClickListener()
        {

        }

    }
    val password=findViewById<EditText>(R.id.editPassword)
    val email=findViewById<EditText>(R.id.editEmailAddress2)
    val button_w=findViewById<Button>(R.id.button2)

    fun login(view: View)
    {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    fun back(view: View)
    {
        val intent = Intent(this, Start::class.java)
        startActivity(intent)
    }



    fun sign()
    {
        val enter_password= password.text.toString()
        val enter_email=email.text.toString()

        auth.createUserWithEmailAndPassword(enter_email, enter_password).addOnCompleteListener(this)
        { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success")
                val user = auth.currentUser
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener(this)
        {
//            exception->
//            Toast.makeText(this.message,Toast.LENGTH_LONG).show()
       }
    }

}