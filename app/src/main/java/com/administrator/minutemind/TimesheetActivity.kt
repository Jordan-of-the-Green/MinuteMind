/***************************************************************************************
 *    Title: <Save Data in Firebase Realtime Database using Kotlin | Realtime Database | Kotlin | Android Studio>
 *    Author: <Foxandroid>
 *    Date Published: <8 April 2021>
 *    Date Retrieved: <01 June 2023>
 *    Code version: <1.0.0>
 *    Availability: <https://www.youtube.com/watch?v=MFcMw9jJA9o&t=557s>
 *
 ***************************************************************************************/

package com.administrator.minutemind

import android.Manifest
import android.app.Activity
import android.net.Uri
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.nfc.FormatException
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.administrator.minutemind.databinding.ActivityTimesheetBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TimesheetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTimesheetBinding
    private lateinit var database: DatabaseReference
    private lateinit var ImageUri: Uri // declaring an ImageURI reference for intended binding use to the firebase storage medium
    private lateinit var addPhoto: Button // declaring a reference to the add photograph button

    // Author: Hasper Ong (2022)
    // URL: Medium (https://medium.com/@hasperong/open-camera-and-display-image-using-kotlin-4f28f9217fa5)
    val REQUEST_CODE = 200 // declaring an image standard image request code to be used as a reference to access the camera functionality in android studio

    lateinit var logo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimesheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener{
            writeData()
        }

        binding.btnHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        addPhoto = findViewById(R.id.btn_Add_Photograph) // declaring button to open the camera for image

        binding.btnAddPhotograph.setOnClickListener {
            photoOption() // method to provide the backend code to access the in-built camera feature in android studio
        }

        val getUserData = findViewById<Button>(R.id.btn_Set_Goals)
        getUserData.setOnClickListener()
        {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun writeData(){
        val name = binding.etName.text.toString()
        val category = binding.etCategory.text.toString()
        val date = binding.etDate.text.toString()
        val endTime = binding.etEndTimes.text.toString()
        val startTimes = binding.etStartTimes.text.toString()
        val description = binding.etDescription.text.toString()
/*        val image1 = binding.imageUser*/

        if(name.isNotEmpty() && category.isNotEmpty()){
            database = FirebaseDatabase.getInstance().getReference("Timesheet Entries")
            val User = User(/*image1,*/category,description,date,startTimes,endTime)
            database.child(name).setValue(User).addOnSuccessListener {
                binding.etName.text.clear()
                binding.etCategory.text.clear()
                binding.etDescription.text.clear()
                binding.etDate.text.clear()
                binding.etStartTimes.text.clear()
                binding.etEndTimes.text.clear()
                binding.imageUser

                Toast.makeText(this, "Successfully Saved",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{
                Toast.makeText(this, "Failure",Toast.LENGTH_SHORT).show()
            }
        }
        try
        {
            val timesheetName = findViewById<EditText>(R.id.et_Name)
            val timesheetCategory = findViewById<EditText>(R.id.et_category)
            val timesheetDescription = findViewById<EditText>(R.id.et_description)
            val timesheetDate = findViewById<EditText>(R.id.et_date)
            val timesheetStart = findViewById<EditText>(R.id.et_start_times)
            val timesheetEnd = findViewById<EditText>(R.id.et_end_times)
        }
        catch (e: FormatException)
        {
            Toast.makeText(this, "Please add all information provided",Toast.LENGTH_SHORT).show()
        }
    }
    private fun photoOption() {
        if (ContextCompat.checkSelfPermission(
                this@TimesheetActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) !==
            PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this@TimesheetActivity,
                    Manifest.permission.CAMERA
                )
            ) {
                ActivityCompat.requestPermissions(
                    this@TimesheetActivity,
                    arrayOf(Manifest.permission.CAMERA), 1
                )
            } else {
                ActivityCompat.requestPermissions(
                    this@TimesheetActivity,
                    arrayOf(Manifest.permission.CAMERA), 1
                )
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    if ((ContextCompat.checkSelfPermission(
                            this@TimesheetActivity,
                            Manifest.permission.CAMERA
                        ) ===
                                PackageManager.PERMISSION_GRANTED)
                    ) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                        capturePhoto()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }
    private fun capturePhoto() {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)

        //The following code was taken from the YouTube channel: FoxAndroid
        // Author: FoxAndroid
        // URL: https://www.youtube.com/watch?v=GmpD2DqQYVk

        // The intention for the code below was to store user selected image in an online platform in the Firebase database

        /*val formatter = SimpleDateFormat("yyy_MM_dd_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")

        storageReference.putFile(ImageUri).addOnSuccessListener() {
            binding.iv.setImageURI(null)

            val intent = Intent() //initializing an intent
            intent.type =
                "Image/*" //naming the intent as Image once the user has clicked on the "Add Photo" button
            intent.action =
                Intent.ACTION_GET_CONTENT //declaring the intent of action to retrieve the image content that is situated locally for the application

            startActivityForResult(
                intent,
                100
            ) // specifying the requirement of a result from the timesheet activity (activity to be invoked) and initializing a request code for this activity to be 100
        }*/

         */


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null) {
            logo = findViewById(R.id.iv)
            logo.setImageBitmap(data.extras?.get("data") as Bitmap)
            /*ImageUri = data?.data!!
            binding.iv.setImageURI(ImageUri)*/
        }
    }
}
