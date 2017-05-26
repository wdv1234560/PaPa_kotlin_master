package com.jiac.papak

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.jiac.papak.ui.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val person = Person("wangnima", 23, "man")
        val textView = findViewById(R.id.tv) as TextView
        textView.setText("Hello Kotlin!")

        bt_run.setOnClickListener { toast(person.run()) }
        bt_recyclerview.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity().javaClass)
            startActivity(intent)
        }
    }


    open class Animal(name: String)

    class Person(name: String, age: Int, sex: String) : Animal(name) {
        init {
            /*构造函数函数体*/
        }

        fun run(): String {
            println("person run!")
            return "person run!"
        }


    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }
}
