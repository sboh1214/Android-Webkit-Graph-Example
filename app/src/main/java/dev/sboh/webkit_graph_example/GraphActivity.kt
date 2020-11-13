package dev.sboh.webkit_graph_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import dev.sboh.webkit_graph_example.databinding.ActivityGraphBinding


class GraphActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGraphBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val entries = ArrayList<Entry>();
        entries.add(Entry(1F,1F))
        entries.add(Entry(2F,2.3F))
        entries.add(Entry(3F,2.8F))

        val dataSet = LineDataSet(entries, "Label")
        val lineData = LineData(dataSet)
        binding.chart.data = lineData
        binding.chart.invalidate() // refresh

    }
}