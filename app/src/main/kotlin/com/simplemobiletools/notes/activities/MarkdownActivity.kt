package com.simplemobiletools.notes.activities

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ScrollView
import com.simplemobiletools.notes.R
import com.simplemobiletools.notes.R.string.scroll_to_bottom
import com.simplemobiletools.notes.R.string.scroll_to_top
import com.simplemobiletools.notes.helpers.MARKDOWN_TEXT
import kotlinx.android.synthetic.main.activity_markdown.*
import kotlinx.android.synthetic.main.activity_markdown.view.*
import ru.noties.markwon.Markwon


class MarkdownActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markdown)

        val message = intent.getStringExtra(MARKDOWN_TEXT)

        val markdown = Markwon.markdown(this, message)
//        Log.d("MarkdownActivity", markdown.toString())
        textView2.text = markdown
        button.visibility = INVISIBLE
        button.text = resources.getString(scroll_to_bottom)
        button.setOnClickListener { scrollToBottom() }

        scrollView2.setOnScrollChangeListener { _: View, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            Log.d("ScrollView", "scrollX_" + scrollX + "_scrollY_" + scrollY + "_oldScrollX_" + oldScrollX + "_oldScrollY_" + oldScrollY)

            if (scrollView2.height * 2 < scrollView2.textView2.height) {
                button.visibility = VISIBLE
            }

            Log.d("textview_height", scrollView2.textView2.height.toString())
            Log.d("scrollView_height", scrollView2.height.toString())
//            if scrollY
        }

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