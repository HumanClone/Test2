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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import java.time.Instant

class SignUp : AppCompatActivity()
{

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = Firebase.auth
    }


    fun login(view: View)
    {

    }

    fun back(view: View)
    {
        val intent = Intent(this, Start::class.java)
        startActivity(intent)
    }

    val password=findViewById<EditText>(R.id.editPassword)
    val email=findViewById<EditText>(R.id.editEmailAddress2)
    val button_w=findViewById<Button>(R.id.button2)

    val enter_password= password.text.toString()
    val enter_email=email.text.toString()


    fun sign()
    {

        auth.createUserWithEmailAndPassword(enter_email, enter_password).addOnCompleteListener(this)
        { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success")
                val user = auth.currentUser
                database.child("users").child(user.toString()).child("TimeCreation").setValue(
                    Instant.now())
                    .addOnSuccessListener {
                        // Success message
                        val intent =  Intent(getBaseContext(), Main_Menu::class.java)
                        startActivity(intent)
                    }
                    .addOnFailureListener {
                        // Failure message
                    }



            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
        }




    }

}