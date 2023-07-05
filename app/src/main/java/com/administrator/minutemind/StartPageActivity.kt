package com.administrator.minutemind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class StartPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startpage)

        val navigatetohomepage = findViewById<Button>(R.id.btHomePage)

        navigatetohomepage.setOnClickListener()
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
