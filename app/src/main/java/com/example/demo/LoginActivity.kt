package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.Adapter.PostAdapter
import com.example.demo.Util.ApiState
import com.example.demo.ViewModel.LoginViewModel
import com.example.demo.ViewModel.MainViewModel
import com.example.demo.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val mainViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            mainViewModel.loginClicked(
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextTextPassword.text.toString()
            )

        }

        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect { it ->
                when (it) {
                    is ApiState.Loading -> {
                        binding.button.isVisible = false
                        binding.progressBar.isVisible = true
                        Log.d("login", "load:")
                    }
                    is ApiState.Failure -> {
                        binding.button.isVisible = true
                        binding.progressBar.isVisible = false
                        Log.d("login", "fail: ${it.msg}")
                    }
                    is ApiState.LoginSuccess -> {
                        binding.button.isVisible = true
                        binding.progressBar.isVisible = false
                        Log.d("login", "pass: ")
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))

                    }
                    is ApiState.Empty -> {

                    }
                }
            }
        }

    }

}