package com.administrator.minutemind

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btPageHome = findViewById<Button>(R.id.btHomepage)
        val btProfilePage = findViewById<Button>(R.id.btProfile)
        val btCreateTimesheet = findViewById<Button>(R.id.btTimesheet)
        val btViewTimesheet = findViewById<Button>(R.id.btNotifications)
        val btSetting = findViewById<Button>(R.id.btSettings)
        val btnLogouts = findViewById<Button>(R.id.btnLogout)
        val btGoals = findViewById<Button>(R.id.btGoals)
        val btVisualFormat = findViewById<Button>(R.id.button25)

        btPageHome.setOnClickListener()
        {
            val intent = Intent(this, StartPageActivity::class.java)
            startActivity(intent)
        }

        btProfilePage.setOnClickListener()
        {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        btCreateTimesheet.setOnClickListener()
        {
            val intent = Intent(this, TimesheetActivity::class.java)
            startActivity(intent)
        }

        btViewTimesheet.setOnClickListener()
        {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }

        btSetting.setOnClickListener()
        {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        btGoals.setOnClickListener()
        {
            val intent = Intent(this, ViewGraph::class.java)
            startActivity(intent)
        }

        btnLogouts.setOnClickListener()
        {
            signOut()
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        btVisualFormat.setOnClickListener()
        {
            val intent = Intent(this, VisualActivity::class.java)
            startActivity(intent)
        }

    }
    private fun signOut() {
        // [START auth_sign_out]
        Firebase.auth.signOut()
        Toast.makeText(this, "Goodbye User: Signed Out", Toast.LENGTH_LONG).show()
        // [END auth_sign_out]
    }
}