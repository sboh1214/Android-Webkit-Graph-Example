package dev.sboh.webkit_graph_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import dev.sboh.webkit_graph_example.databinding.ActivityWebHtmlBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebHtmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebHtmlBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.webView.loadUrl("https://github.com/sboh1214/Android-Webkit-Graph-Example")
    }
}