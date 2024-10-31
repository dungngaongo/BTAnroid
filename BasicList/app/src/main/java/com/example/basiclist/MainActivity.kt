package com.example.basiclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var edtNumber: EditText
    private lateinit var radioEven: RadioButton
    private lateinit var radioOdd: RadioButton
    private lateinit var radioSquare: RadioButton
    private lateinit var btnShow: Button
    private lateinit var listViewResult: ListView
    private lateinit var txtError: TextView
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber = findViewById(R.id.edtNumber)
        radioEven = findViewById(R.id.radioEven)
        radioOdd = findViewById(R.id.radioOdd)
        radioSquare = findViewById(R.id.radioSquare)
        btnShow = findViewById(R.id.btnShow)
        listViewResult = findViewById(R.id.listViewResult)
        txtError = findViewById(R.id.txtError)
        radioGroup = findViewById(R.id.radioGroup)

        btnShow.setOnClickListener {
            txtError.text = ""
            val input = edtNumber.text.toString()
            if (input.isEmpty()) {
                txtError.text = "Vui lòng nhập số nguyên dương n."
                return@setOnClickListener
            }

            val n = input.toIntOrNull()
            if (n == null || n < 0) {
                txtError.text = "Dữ liệu không hợp lệ. Vui lòng nhập số nguyên dương."
                return@setOnClickListener
            }

            val resultList = mutableListOf<Int>()
            when (radioGroup.checkedRadioButtonId) {
                R.id.radioEven -> {
                    for (i in 0..n) {
                        if (i % 2 == 0) {
                            resultList.add(i)
                        }
                    }
                }
                R.id.radioOdd -> {
                    for (i in 1..n) {
                        if (i % 2 != 0) {
                            resultList.add(i)
                        }
                    }
                }
                R.id.radioSquare -> {
                    var i = 0
                    while (i * i <= n) {
                        resultList.add(i * i)
                        i++
                    }
                }
                else -> {
                    txtError.text = "Vui lòng chọn loại số."
                    return@setOnClickListener
                }
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList)
            listViewResult.adapter = adapter
        }
    }
}