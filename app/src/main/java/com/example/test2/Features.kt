package com.example.test2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test2.Models.Preferences
import com.example.test2.databinding.ActivityFeaturesBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Features : AppCompatActivity() {

    private lateinit var binding: ActivityFeaturesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeaturesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            SaveBtn.setOnClickListener()
            {
                val darktheme= Dswitch.isChecked()
                val language:String =Languagetf.toString()
                val timezone=TimeZonetf.toString()

                val feat=Preferences(darktheme,timezone,language)

                val database=Firebase.database
                val user:String?=intent.getStringExtra("User")
                val userid: String=user.toString()
                val myRef=database.getReference("Perfernces").child(userid)
                myRef.push().setValue(feat)
                Toast.makeText(this@Features,  userid, Toast.LENGTH_SHORT).show()




            }
        }


    }


}