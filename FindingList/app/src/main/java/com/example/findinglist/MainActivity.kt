package com.example.findinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var etSearch: EditText
    private lateinit var allStudents: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSearch = findViewById(R.id.etSearch)
        recyclerView = findViewById(R.id.rvStudents)

        allStudents = generateStudentList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        studentAdapter = StudentAdapter(allStudents)
        recyclerView.adapter = studentAdapter

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val keyword = s.toString().trim()
                if (keyword.length > 2) {
                    val filteredList = allStudents.filter {
                        it.name.contains(keyword, ignoreCase = true) ||
                                it.studentId.contains(keyword, ignoreCase = true)
                    }
                    studentAdapter.updateList(filteredList)
                } else {
                    studentAdapter.updateList(allStudents)
                }
            }
        })
    }

    private fun generateStudentList(): List<Student> {
        return listOf(
            Student("Nguyễn Văn An", "SV001"),
            Student("Trần Thị Bình", "SV002"),
            Student("Lê Văn Cường", "SV003"),
            Student("Phạm Thị Dung", "SV004"),
            Student("Hoàng Văn Em", "SV005"),
            Student("Đặng Thị Phương", "SV006"),
            Student("Vũ Văn Hùng", "SV007"),
            Student("Bùi Thị Lan", "SV008"),
            Student("Đỗ Văn Minh", "SV009"),
            Student("Phan Thị Ngọc", "SV010"),
            Student("Phan Đình Can", "SV011")
        )
    }
}
