package com.example.cv.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cv.MainActivity
import com.example.cv.R

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEmailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEmailEditText = findViewById(R.id.username_email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)
        errorTextView = findViewById(R.id.error_text_view)

        loginButton.setOnClickListener {
            val usernameEmail = usernameEmailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Implement your authentication logic here
            if (isValidCredentials(usernameEmail, password)) {
                // Successful login, navigate to the main activity or desired screen
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Display an error message
                errorTextView.text = getString(R.string.error_invalid_credentials)
                errorTextView.visibility = View.VISIBLE
            }
        }
    }

    private fun isValidCredentials(usernameEmail: String, password: String): Boolean {
        // Replace this with your actual authentication logic
        // For example, you might check against a local database or a server
        return usernameEmail == "angel" && password == "12345" // Replace with your actual credentials
    }
}