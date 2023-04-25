package com.example.test2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.test2.databinding.ActivityMainMenuBinding
import com.google.firebase.auth.FirebaseAuth

class Main_Menu : AppCompatActivity() {
    lateinit var binding:ActivityMainMenuBinding
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (getIntent().getStringExtra("darkmode").toBoolean())
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        binding.apply {
            toggle =
                ActionBarDrawerToggle(this@Main_Menu, drawLayout,toolbar, R.string.open, R.string.close)
            drawLayout.addDrawerListener(toggle)
            toggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navView.setNavigationItemSelectedListener{
                it.isChecked=true
                when(it.itemId) {
                    R.id.nav_profile -> {loadFrag(ProfileFragment())
                                        binding.drawLayout.closeDrawers()}
                    R.id.nav_cv_edit -> { loadFrag(EditFragment())
                                        binding.drawLayout.closeDrawers()}
                    R.id.nav_settings ->{ loadFrag(SettingsFragment())
                                        binding.drawLayout.closeDrawers()}
                    R.id.nav_cv -> {loadFrag(ViewFragment())
                                     binding.drawLayout.closeDrawers()}
                    R.id.nav_upload -> {loadFrag(UploadFragment())
                        binding.drawLayout.closeDrawers()}
                }
                true
            }

        }

    }



    fun loadFrag(fragment:Fragment)
    {
        val fragmentManager  =supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.draw_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu , menu)
        return true
    }





}