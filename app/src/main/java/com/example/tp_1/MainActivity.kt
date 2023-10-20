package com.example.tp_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.MutableLiveData
import androidx.core.widget.addTextChangedListener
import android.widget.EditText
import android.widget.CheckBox
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.NavHostFragment
import java.util.EventObject


class SignInViewModel : ViewModel() {
    // LiveData for storing form data
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val rememberMe = MutableLiveData<Boolean>()

    fun onSignInClicked() {
    }
}

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        // Bind XML elements to ViewModel properties
        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val rememberMeCheckbox = findViewById<CheckBox>(R.id.remember_me_checkbox)
        val signInButton = findViewById<Button>(R.id.sign_in_button)

        emailEditText.addTextChangedListener {
            viewModel.email.value = it.toString()
            println(viewModel)
        }

        passwordEditText.addTextChangedListener {
            viewModel.password.value = it.toString()
        }

        rememberMeCheckbox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.rememberMe.value = isChecked
        }

        signInButton.setOnClickListener {
            viewModel.onSignInClicked()
        }

    }
}