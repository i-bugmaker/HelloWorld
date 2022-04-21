package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        val extraData = intent.getStringExtra("myData")
//        println(extraData)
        val button2 = findViewById<Button>(R.id.btn2)
        button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return", "Hello First")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello First")
        setResult(RESULT_OK, intent)
        finish()
    }
}