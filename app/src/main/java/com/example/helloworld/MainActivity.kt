package com.example.helloworld

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btn1)
        button.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
//            显示intent
//            val data = "Hello!!!~~~"
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("myData",data)
//            startActivity(intent)
//            隐式intent
//            val intent = Intent("com.example.helloworld.HUANGMENGHUI")
//            intent.addCategory("MY_CATEGORY")
//            其他程序的activity
//            val intent = Intent(ACTION_VIEW)
//            intent.data = Uri.parse("geo:231")
//            startActivity(intent)
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnData = data?.getStringExtra("data_return")
                println(returnData)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "add a item!", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "remove a item!", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}