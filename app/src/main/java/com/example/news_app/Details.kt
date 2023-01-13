package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var webview = findViewById<WebView>(R.id.webview)
        var bar = findViewById<ProgressBar>(R.id.progressBar)
        var url = intent.getStringExtra("URL")

        if (url!=null)
        {
            webview.settings.javaScriptEnabled = true
            webview.settings.userAgentString = "Mozilla/5.0 (Linux; U; Android 2.2; en-gb; Nexus One Build/FRF50) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1"
            webview.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    bar.visibility = View.GONE
                    webview.visibility = View.VISIBLE
                }
            }
            webview.loadUrl(url)
        }
    }
}