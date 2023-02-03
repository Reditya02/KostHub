package com.example.kosthub.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.example.kosthub.R
import com.example.kosthub.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideNavbar()
    }

    fun showNavbar(menu: Int) {
        binding.apply {
            navBottom.apply {
                visibility = View.VISIBLE
                if (getMenu().size() <= 1) {
                    getMenu().clear()
                    inflateMenu(menu)
                }
            }
            frame.apply {
                layoutParams.height = 0
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            }
        }
    }

    fun hideNavbar() {
        binding.apply {
            navBottom.apply {
                visibility = View.GONE
            }
            frame.apply {
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            }
        }
    }
}