package com.example.a0328class

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.btnChangeActibity)
        val btnChangeActivity2 = findViewById<Button>(R.id.btnChangeActibity2)
        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)
        val edtName = findViewById<TextView>(R.id.edtName)

        btnChangeActivity.setOnClickListener {
            var bundle = Bundle()
            var name = edtName.text.toString()
            bundle.putString("name",name)


            val seconIntent = Intent(this,game1::class.java)
            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }

        btnChangeActivity2.setOnClickListener {
            var bundle = Bundle()
            var name = edtName.text.toString()
            bundle.putString("name",name)

            val seconIntent = Intent(this,game2::class.java)
            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }

        btnOpenBrowser.setOnClickListener {
            var seconIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(seconIntent)
        }

    }
}