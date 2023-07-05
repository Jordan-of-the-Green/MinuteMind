package com.administrator.minutemind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


///////////////////////////////////////////////////////////////////////////////

var totalhours: Int = 0
var result1: Int = 0

var numMin1: Int = 0
var numMax1: Int = 0

///////////////////////////////////////////////////////////////////////////////

class VisualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visual_feature)

        ///////////////////////////////////////////////////////////////////////////////

        val total = findViewById<EditText>(R.id.etTotalhours)
        val numPickMin = findViewById<EditText>(R.id.editTextMinimumNumber)
        val numPickMax = findViewById<EditText>(R.id.editTextMaximumNumber)

        val imageView = ImageView(this)
        // setting height and width of imageview
        imageView.layoutParams= LinearLayout.LayoutParams(400, 400)
        imageView.x= 20F // setting margin from left
        imageView.y= 20F // setting margin from top

        ///////////////////////////////////////////////////////////////////////////////

        // accessing our custom image which we added in drawable folder
        val imgResId = R.drawable.great_job_image
        var resId = imgResId

        // accessing our custom image which we added in drawable folder
        val imgResId1 = R.drawable.bad_job_image
        var resId1 = imgResId1

        ///////////////////////////////////////////////////////////////////////////////

        // button onClick listener
        val button = findViewById<Button>(R.id.button25)
        button?.setOnClickListener{

            totalhours = total.text.toString().toInt() //initializing the total hours as a integer
            result1 = totalhours * 30

            numMin1 = numPickMin.text.toString().toInt() //initializing the minimum hours as a integer
            numMax1 = numPickMax.text.toString().toInt() //initializing the maximum hours as a integer

            if(result1 < numMin1)
                imageView.setImageResource(imgResId1)
            else if (result1 > numMax1)
                imageView.setImageResource(imgResId1)
            else
                imageView.setImageResource(imgResId)
        }

        ///////////////////////////////////////////////////////////////////////////////

        // accessing our relative layout from activity_main.xml
        val layout = findViewById<LinearLayout>(R.id.layout)

        // Add ImageView to LinearLayout
        layout?.addView(imageView) // adding image to the layout

        ///////////////////////////////////////////////////////////////////////////////

    }
}