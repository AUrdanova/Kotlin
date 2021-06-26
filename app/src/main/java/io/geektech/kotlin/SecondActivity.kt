package io.geektech.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*



class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ed_second.setText(intent.getStringExtra(TOTAL_COUNT))
        init()

    }

    private fun init() {
        btn_second.setOnClickListener {
            if (ed_second.text.isEmpty()) {
                Toast.makeText(this, "Enter text", Toast.LENGTH_SHORT).show()
            } else {
                setResult(Activity.RESULT_OK, Intent().putExtra(TOTAL_COUNT, ed_second.text.toString()))
                finish()
            }
        }
    }

    companion object {
        const val TOTAL_COUNT = "total_count"
    }
}