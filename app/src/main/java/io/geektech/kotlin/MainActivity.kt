package io.geektech.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var resultName : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        resultName = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            resultName ->
            if (resultName.resultCode == Activity.RESULT_OK) {
                val name = resultName.data?.getStringExtra(SecondActivity.TOTAL_COUNT).toString()
                ed_first.setText(name)
            }
        }

        btn_first.setOnClickListener {
            if(ed_first.text.isEmpty()) {
                Toast.makeText(this, "Enter text", Toast.LENGTH_SHORT).show()
            } else{
               resultName.launch(Intent(this, SecondActivity :: class.java)
                   .putExtra(SecondActivity.TOTAL_COUNT, ed_first.text.toString()))
            }
        }
    }
}