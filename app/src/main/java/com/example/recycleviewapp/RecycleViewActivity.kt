package com.example.recycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.nio.file.Files.exists

class RecycleViewActivity : AppCompatActivity() {

    private lateinit var db : DatabaseReference
    private lateinit var studentRecycleView : RecyclerView
    private lateinit var studentArrayList : ArrayList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        studentRecycleView = findViewById(R.id.studentsRecyclerView)
        studentRecycleView.layoutManager = LinearLayoutManager(this)
        studentRecycleView.setHasFixedSize(true)

        studentArrayList = arrayListOf<Student>()
        GetStudentData()
    }

    private fun GetStudentData(){
        db = FirebaseDatabase.getInstance().getReference("Students")

        db.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for(studentSnapshot in snapshot.children){
                        val student = studentSnapshot.getValue(Student::class.java)
                        studentArrayList.add(student!!)
                    }

                    studentRecycleView.adapter = MyAdapter(studentArrayList)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}