package com.example.notepad


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var res: String = " "
    lateinit var sPref: SharedPreferences
    private val SAVED_TEXT: String = "saved_text"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun save(view: View){
        val edit: EditText = findViewById(R.id.input)
        res = edit.text.toString()
        saveText(res)
    }

    private fun saveText(res: String) {
        sPref = getPreferences(Context.MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString(SAVED_TEXT, res)
        ed.apply()
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
    }
    fun load(view: View){
        val edit: EditText = findViewById(R.id.input)
        edit.setText(loadText() , TextView.BufferType.EDITABLE)
    }

    private fun loadText(): String {
        sPref = getPreferences(Context.MODE_PRIVATE)
        return sPref.getString(SAVED_TEXT, " ") ?: "Button \"Load\" is loading your note from memory\nButton \"Save\" is saving your note to memory\nGood luck!"
    }
}
