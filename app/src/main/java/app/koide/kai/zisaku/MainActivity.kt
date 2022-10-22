package app.koide.kai.zisaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.koide.kai.zisaku.databinding.ActivityMainBinding
import app.koide.kai.zisaku.databinding.ActivityWordExpianationactivityBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        binding.wordbutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, Listactivity::class.java)
            startActivity(toSecondActivityIntent)
        }
    }


}