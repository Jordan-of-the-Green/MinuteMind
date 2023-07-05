package com.administrator.minutemind

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import android.graphics.Color
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import java.util.*


class ViewGraph : AppCompatActivity() {

    private lateinit var minEditText: EditText
    private lateinit var maxEditText: EditText
    private lateinit var datePicker: DatePicker
    private lateinit var totalHoursEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var graph: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graph)

        minEditText = findViewById(R.id.minText)
        maxEditText = findViewById(R.id.maxText)
        datePicker = findViewById(R.id.graph_date)
        totalHoursEditText = findViewById(R.id.Totaltext)
        saveButton = findViewById(R.id.sbutton)
        graph = findViewById(R.id.graph)


        saveButton.setOnClickListener {
            saveDataAndDrawGraph()
        }
    }

    private fun saveDataAndDrawGraph() {
        val min = minEditText.text.toString().toFloatOrNull()
        val max = maxEditText.text.toString().toFloatOrNull()
        val totalHours = totalHoursEditText.text.toString().toFloatOrNull()

        if (min != null && max != null && totalHours != null) {
            val entries = ArrayList<BarEntry>()
            entries.add(BarEntry(0f, min))
            entries.add(BarEntry(1f, max))
            entries.add(BarEntry(2f, totalHours))

            val dataSet = BarDataSet(entries, "Goals and Hours")
            dataSet.colors = listOf(Color.YELLOW, Color.GREEN, Color.WHITE)

            val barData = BarData(dataSet)
            graph.data = barData

            graph.invalidate()
        }
    }
}
