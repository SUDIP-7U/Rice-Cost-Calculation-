package com.example.newapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newapplication.databinding.ActivityMainBinding
import com.example.newapplication.ui.fragment.RiceFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Load the RiceFragment into FrameLayout

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, RiceFragment())
            .commit()
    }
}
