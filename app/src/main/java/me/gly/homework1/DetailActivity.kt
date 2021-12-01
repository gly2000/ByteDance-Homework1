package me.gly.homework1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val name: String? = intent.extras!!.getString("name")
        val gender:String? = intent.extras!!.getString("gender")
        val age:String? = intent.extras!!.getString("age")
        val health:String? = intent.extras!!.getString("health")
        val info:String? = intent.extras!!.getString("description")
        findViewById<TextView>(R.id.detail_name).setText(name)
        findViewById<TextView>(R.id.detail_gender).setText(gender)
        findViewById<TextView>(R.id.detail_age).setText(age)
        findViewById<TextView>(R.id.detail_health).setText(health)
        findViewById<TextView>(R.id.detail_info).setText(info)

        val returnBtn = findViewById<Button>(R.id.return_btn)
        returnBtn.setOnClickListener({ startActivity(Intent(this, MainActivity::class.java)) })
    }
}
