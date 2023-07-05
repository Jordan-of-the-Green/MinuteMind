package com.administrator.minutemind

import android.media.Image
import android.widget.DatePicker
import android.widget.ImageView
import com.google.firebase.database.IgnoreExtraProperties
import java.util.Date

// [START rtdb_user_class]
@IgnoreExtraProperties
data class User(
/*    val image1: ImageView? = null,*/
    val name: String? = null,
    val category: String? = null,
    val date: String? = null,
    val startTimes: String? = null,
    val endTimes: String? = null,
    val description: String? = null,
    val min: String? = null,
    val max: String? = null)
{

}