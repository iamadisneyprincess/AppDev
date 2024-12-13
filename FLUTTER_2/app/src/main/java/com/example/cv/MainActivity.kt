package com.example.cv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cv.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.example.cv.ui.login.LoginActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize DrawerLayout and NavigationView
        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        // Set up the custom Toolbar as the ActionBar
        setSupportActionBar(binding.appBarMain.toolbar)

        // Set up the Navigation Controller
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Configure the AppBar with the top-level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_education,
                R.id.nav_experience
            ), drawerLayout
        )

        // Set up the ActionBar and NavigationView with the NavController
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Set up the ActionBarDrawerToggle to handle the navigation drawer
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.appBarMain.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()  // Sync the state of the drawer with the toolbar's hamburger icon

        // Handle logout button click
        val logoutButton: Button = findViewById(R.id.logout_button)
        logoutButton.setOnClickListener {
            // Handle the logout logic here, for example:
            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()

            // If you're navigating to a login screen after logout, you can use:
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
