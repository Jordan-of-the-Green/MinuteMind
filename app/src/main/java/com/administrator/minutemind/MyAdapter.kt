/***************************************************************************************
 *    Title: <Firebase Data to RecyclerView using Kotlin | Retrieve Firebase data into RecyclerView | Kotlin |>
 *    Author: <Foxandroid>
 *    Date Published: <19 April 2021>
 *    Date Retrieved: <04 June 2023>
 *    Code version: <1.0.0>
 *    Availability: <https://www.youtube.com/watch?v=VVXKVFyYQdQ>
 *
 ***************************************************************************************/


package com.administrator.minutemind

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.administrator.minutemind.R


class MyAdapter(private val userList : List<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return MyViewHolder(itemView)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
/*        holder.image10.text = currentItem.image1.toString()*/

        // sets the image to the imageview from our itemHolder class

        holder.name1.text = currentItem.name
        holder.category1.text = currentItem.category
        holder.description1.text = currentItem.description
        holder.date1.text = currentItem.date.toString()
        holder.startTimes1.text = currentItem.startTimes
        holder.endTimes1.text = currentItem.endTimes
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return userList.size
    }

    // Holds the views for adding it to image and text
    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
/*        var image10: TextView = itemView.findViewById(R.id.imageRecyclerView)*/
        val name1: TextView = itemView.findViewById(R.id.name)
        val category1: TextView = itemView.findViewById(R.id.category)
        val description1: TextView = itemView.findViewById(R.id.description)
        val date1: TextView = itemView.findViewById(R.id.date)
        val startTimes1: TextView = itemView.findViewById(R.id.starttimes)
        val endTimes1: TextView = itemView.findViewById(R.id.endtimes)
    }
}