package com.simplemobiletools.notes.activities

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ScrollView
import com.simplemobiletools.notes.R
import com.simplemobiletools.notes.R.string.scroll_to_bottom
import com.simplemobiletools.notes.R.string.scroll_to_top
import com.simplemobiletools.notes.helpers.MARKDOWN_TEXT
import kotlinx.android.synthetic.main.activity_markdown.*
import ru.noties.markwon.Markwon


class MarkdownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markdown)


        val intent = intent
        val message = intent.getStringExtra(MARKDOWN_TEXT)

        val markdown = Markwon.markdown(this, message)
        Log.d("MarkdownActivity", markdown.toString())
        textView2.setText(markdown)
        button.text = resources.getString(scroll_to_bottom)
        button.setOnClickListener { scrollToBottom() }
    }

    fun scrollToTop() {
        val handler = Handler()
        handler.post {
            //设置ScrollView滚动到顶部
            scrollView2.fullScroll(ScrollView.FOCUS_UP);

            button.text = resources.getString(scroll_to_bottom)
            button.setOnClickListener { scrollToBottom() }

        }
    }

    fun scrollToBottom() {
        val handler = Handler()
        handler.post {
            //设置ScrollView滚动到底部
            scrollView2.fullScroll(ScrollView.FOCUS_DOWN)

            button.text = resources.getString(scroll_to_top)
            button.setOnClickListener { scrollToTop() }
        }
    }
}