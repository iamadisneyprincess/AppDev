package com.example.cv.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        // Initialize views
        usernameEmailEditText = findViewById(R.id.username_email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)
        errorTextView = findViewById(R.id.error_text_view)

        // Set click listener for login button
        loginButton.setOnClickListener {
            val usernameEmail = usernameEmailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validate input fields
            if (usernameEmail.isBlank() || password.isBlank()) {
                errorTextView.text = getString(R.string.error_empty_fields)
                errorTextView.visibility = View.VISIBLE
                return@setOnClickListener
            }

            // Log to check credentials (Remove in production)
            Log.d("LoginActivity", "Login attempt detected.")

            // Validate credentials
            if (isValidCredentials(usernameEmail, password)) {
                // Reset error and navigate to MainActivity
                errorTextView.visibility = View.GONE
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Show error message if credentials are invalid
                errorTextView.text = getString(R.string.error_invalid_credentials)
                errorTextView.visibility = View.VISIBLE
            }
        }
    }

    // Simple validation method (replace with actual logic)
    private fun isValidCredentials(usernameEmail: String, password: String): Boolean {
        // Replace with actual authentication logic (e.g., checking a database or API)
        return usernameEmail == "angel" && password == "12345"  // Example credentials
    }
}
