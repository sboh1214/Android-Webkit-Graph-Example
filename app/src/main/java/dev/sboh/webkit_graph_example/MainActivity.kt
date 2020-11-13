package dev.sboh.webkit_graph_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.sboh.webkit_graph_example.databinding.ActivityMainBinding
import dev.sboh.webkit_graph_example.databinding.RecyclerItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val list = ArrayList<Subject>()
        list.add(Subject("Hello"))

        val adapter = RecyclerAdapter(list)
        binding.recyclerView.adapter = adapter
    }
}

data class Subject(val title: String) {

}

class RecyclerAdapter(private val items: ArrayList<Subject>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener {
            Toast.makeText(it.context, "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecyclerItemBinding.bind(view)

        fun bind(listener: View.OnClickListener, item: Subject) {
            binding.textView.text = item.title
            binding.root.setOnClickListener(listener)
        }
    }
}
