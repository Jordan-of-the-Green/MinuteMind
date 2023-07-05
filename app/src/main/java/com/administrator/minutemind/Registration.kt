/***************************************************************************************
 *    Title: <Get Started with Firebase Authentication on Android>
 *    Author: <Firebase>
 *    Date Published: <1 June 2023>
 *    Date Retrieved: <1 June 2023>
 *    Code version: <1.0.0>
 *    Availability: <https://firebase.google.com/docs/auth/android/start#optional_prototype_and_test_with>
 *
 ***************************************************************************************/


package com.administrator.minutemind

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registration : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val login = findViewById<Button>(R.id.btLogins)
        val registration = findViewById<Button>(R.id.btRegistration)

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    fun reload(){
        setContentView(R.layout.activity_registration)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     fun btRegistration(view: View) {
        // call in UI VARIABLES and cast TYPES
        val registration = findViewById<Button>(R.id.btRegistration)
        val email = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)
        val entered_email = email.text.toString();
        val entered_password = password.text.toString();

        auth.createUserWithEmailAndPassword(entered_email, entered_password)
            .addOnCompleteListener(this) {

                if (it.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    val user = auth.currentUser
                }
                else if (entered_email.isNullOrEmpty() && entered_password.isNullOrEmpty()) {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Write in words ", Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    fun btLogin(view: View) {
        // call in UI VARIABLES and cast TYPES
        val login = findViewById<Button>(R.id.btLogins)
        val email = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)
        val entered_email = email.text.toString();
        val entered_password = password.text.toString();

        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(entered_email, entered_password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    val user = auth.currentUser
                } else if (entered_email.isNullOrEmpty() && entered_password.isNullOrEmpty()) {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Write in words ", Toast.LENGTH_SHORT).show()
                } else
                // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
            }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

