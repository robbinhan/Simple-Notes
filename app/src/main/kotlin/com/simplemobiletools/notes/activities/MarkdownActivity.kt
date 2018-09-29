package com.simplemobiletools.notes.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.simplemobiletools.notes.R
import kotlinx.android.synthetic.main.activity_markdown.*


class MarkdownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markdown)

        // Get the Intent that started this activity and extract the string
        val intent = intent
        val message = intent.getStringExtra("EXTRA_MESSAGE")

        textView2.setText(message)
    }
}