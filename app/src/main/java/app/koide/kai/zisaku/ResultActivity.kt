package app.koide.kai.zisaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.koide.kai.zisaku.databinding.ActivityQuizBinding
import app.koide.kai.zisaku.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        binding.buckbutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, QuizActivityMain::class.java)
            startActivity(toSecondActivityIntent)
        }
        binding.continuebutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, TakeQuizActivity::class.java)
            startActivity(toSecondActivityIntent)
        }
    }
}