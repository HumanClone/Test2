package com.example.test2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.Menu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.google.firebase.database.DatabaseReference
import com.example.test2.databinding.FragmentSettingsBinding



class SettingsFragment : Fragment() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val databaseRef = database.child("users").child("EB").child("MovieList")
        val movieListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val movies = dataSnapshot.getValue<List<Movie>>()?.filterNotNull()
                Log.i("MovieRetrieved", movies.toString())
                if (movies != null) {

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("MoviesRetrievalError", error.toString())
            }

        }
        databaseRef.addValueEventListener(movieListener)
    }
//    fun generateRecyclerView(movieData: List<Movie>) {
//        val recyclerview = findViewById<RecyclerView>(R.id.MoviesRecyclerView)
//        recyclerview.layoutManager = LinearLayoutManager(this)
//        Log.i("MoviesToShow", movieData.toString())
//        val adapter = CustomAdapter(movieData)
//        recyclerview.adapter = adapter
//    }

}
