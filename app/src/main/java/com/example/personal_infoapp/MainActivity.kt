package com.example.personal_infoapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var checkBoxTerms: CheckBox
    private lateinit var buttonSave: Button
    private lateinit var recyclerView: RecyclerView

    private val userInfoList = mutableListOf<UserInfo>()
    private lateinit var adapter: UserInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhone = findViewById(R.id.editTextPhone)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        checkBoxTerms = findViewById(R.id.checkBoxTerms)
        buttonSave = findViewById(R.id.buttonSave)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserInfoAdapter(userInfoList)
        recyclerView.adapter = adapter

        buttonSave.setOnClickListener {
            saveUserInfo()
        }
    }

    private fun saveUserInfo() {
        val name = editTextName.text.toString()
        val email = editTextEmail.text.toString()
        val phone = editTextPhone.text.toString()
        val genderId = radioGroupGender.checkedRadioButtonId
        val gender = findViewById<RadioButton>(genderId)?.text.toString()

        if (checkBoxTerms.isChecked) {
            val userInfo = UserInfo(name, email, phone, gender)
            userInfoList.add(userInfo)
            adapter.notifyDataSetChanged()
            clearInputFields()
        } else {
            Toast.makeText(this, "Vui lòng đồng ý với điều khoản sử dụng", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearInputFields() {
        editTextName.text.clear()
        editTextEmail.text.clear()
        editTextPhone.text.clear()
        radioGroupGender.clearCheck()
        checkBoxTerms.isChecked = false
    }
}
