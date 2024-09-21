package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtName: EditText = findViewById(R.id.txtName)
        val btnOk: Button = findViewById(R.id.btnOk)
        val lblName: TextView = findViewById(R.id.lblName)

        btnOk.setOnClickListener() {
            lblName.text = ""
            if (txtName.text.trim().toString().equals("")) {
                Toast.makeText(this, "Introdueix un nom si us plau", Toast.LENGTH_LONG)
                    .show()
            } else {
                lblName.text = "El teu nom és: " + txtName.text
            }
        }

        val grpColor = findViewById<RadioGroup>(R.id.grpColor)
        val rbRed = findViewById<RadioButton>(R.id.RbRed)
        val rbGreen = findViewById<RadioButton>(R.id.RbGreen)
        val rbBlue = findViewById<RadioButton>(R.id.RbBlue)

        grpColor.setOnCheckedChangeListener { radioGroup, checkedId ->
            val lblColor = findViewById<TextView>(R.id.lblColor)
            when (radioGroup.checkedRadioButtonId) {
                R.id.RbRed -> lblColor.setTextColor(resources.getColor(R.color.red, theme))
                R.id.RbGreen -> lblColor.setTextColor(resources.getColor(R.color.green, theme))
                R.id.RbBlue -> lblColor.setTextColor(resources.getColor(R.color.blue, theme))
            }


        }
        rbRed.setOnClickListener()
        {
            updateName(rbRed)

        }
        rbGreen.setOnClickListener()
        {
            updateName(rbGreen)

        }
        rbBlue.setOnClickListener()
        {
            updateName(rbBlue)
        }

    }

    fun updateName(button: RadioButton) {
        val lblColor = findViewById<TextView>(R.id.lblColor)
        val name = button.text.toString()
        lblColor.text = name
    }
}