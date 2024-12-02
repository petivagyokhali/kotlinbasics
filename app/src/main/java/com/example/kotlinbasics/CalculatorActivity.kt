package com.example.kotlinbasics

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {
    private lateinit var elsoSzamEditText: EditText
    private lateinit var masodikSzamEditText: EditText
    private lateinit var osszeadasButton: Button
    private lateinit var torlesButton: Button
    private lateinit var eredmenyTextView: TextView

    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        elsoSzamEditText = findViewById(R.id.elsoSzamEditText)
        masodikSzamEditText = findViewById(R.id.masodikSzamEditText)
        osszeadasButton = findViewById(R.id.osszeadasButton)
        torlesButton = findViewById(R.id.torlesButton)
        eredmenyTextView = findViewById(R.id.eredmenyTextView)

        osszeadasButton.setOnClickListener(){
            if(elsoSzamEditText.length()!=0&&masodikSzamEditText.length()!=0){
                val elsoszam=Integer.getInteger(elsoSzamEditText.text.toString())
                val masodikszam=Integer.getInteger(masodikSzamEditText.text.toString())

                eredmenyTextView.text= (elsoszam+masodikszam).toString()
            }
        }
    }
}