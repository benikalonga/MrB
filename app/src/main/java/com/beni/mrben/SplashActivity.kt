package com.beni.mrben

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import com.beni.mrben.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFullscreen()
        initViews()
    }
    private fun setFullscreen() = if (Build.VERSION.SDK_INT >= 30) {
        binding.fullscreenContent.windowInsetsController!!.hide(
            WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars()
        )
    } else {
        binding.fullscreenContent.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    private fun initViews() {
        binding.fullscreenContent.setOnClickListener {
            val actionBar = supportActionBar
            if (actionBar != null) {
                if (actionBar.isShowing) {
                    setFullscreen()
                } else {
                    actionBar.show()
                }
            }
        }
        binding.fullscreenContent.apply {
            postDelayed({
                binding.loading.visibility = View.VISIBLE
            }, 1000)
            postDelayed({
                binding.loading.visibility = View.GONE
                binding.loading.stopBlinking()
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
                finish()
            }, 3000)
        }

    }
}