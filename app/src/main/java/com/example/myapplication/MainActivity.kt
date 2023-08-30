package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var num: Int = 0
    var texto: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tV: TextView = findViewById(R.id.textView)
        texto = tV.text as String
    }

    override fun onPause() {
        val tV: TextView = findViewById(R.id.textView)
        texto = tV.text as String
        super.onPause()
        Log.i("PAUSADO","Se pausó porque giró")
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        Log.i("MyTag", "onSaveInstanceState")

        outState.putInt("waos", num)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MyTag", "onRestoreInstanceState")

        num = savedInstanceState.getInt("waos")
        var tV: TextView = findViewById(R.id.textView)
        tV.text = "Pressed: "+num
    }

    fun cambiarTexto(view: View){
        Log.i("LOGGER","Mostrando texto en el Logcat")
        Toast.makeText(applicationContext,"Pressed: "+num,Toast.LENGTH_LONG).show()

        num += 1
        val tV: TextView = findViewById(R.id.textView)
        tV.text = "Pressed: "+num

    }
}