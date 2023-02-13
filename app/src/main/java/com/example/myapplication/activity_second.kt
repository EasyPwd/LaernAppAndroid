package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class activity_second : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            var data: Intent? = result.data
            val textView = findViewById<TextView>(R.id.textViewSecondActivity)
            if (data!=null) {
                textView.text = "This text from intent: " + data.getStringExtra("text") + " " + result.resultCode
            } else {
                textView.text = "No intent data"
            }
        } else {
            Log.e("error", "Activity.RESULT_OK is err")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btnSecondActivity = findViewById<Button>(R.id.button_run_first_activivty)
        btnSecondActivity.setOnClickListener{
            Log.v("my_tag", "button vText was pressed")
            val intent = Intent(this, MainActivity::class.java)
            val editTextSecAct = findViewById<EditText>(R.id.editTextSecAct)
            val text = "This text from textview of Activity1: " + editTextSecAct.text
            intent.putExtra("text", text)
            resultLauncher.launch(intent)
        }

    }
}