package dev.sboh.webkit_graph_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.sboh.webkit_graph_example.databinding.ActivityWebHtmlBinding

class HtmlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebHtmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebHtmlBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.webView.loadUrl("file:///android_asset/sample.html")
    }
}