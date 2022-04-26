package com.beni.mrben

import android.os.Bundle
import android.preference.PreferenceManager
import android.text.TextUtils
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.beni.mrben.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    var emailSaved : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retreive the navigation controller (The fragment conroller)
        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        binding.navView.setupWithNavController(navController)

        iniView()
        initUser()
    }
    fun iniView(){
        binding.btnConnexion.apply {
            setOnClickListener {
                val email = binding.editMail.text.toString()
                if (TextUtils.isEmpty(email)){
                    Snackbar.make(it, "Enter your email address", Snackbar.LENGTH_LONG).show()
                }
                else{

                }
            }
        }
    }
    fun initUser(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        if (TextUtils.isEmpty(pref.getString("email", ""))){
            binding.fragmentConnexion.visibility = VISIBLE
            binding.navView.visibility = GONE
        }
        else{
            binding.fragmentConnexion.visibility = GONE
            binding.navView.visibility = VISIBLE
        }
    }
}