package app.koide.kai.zisaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import app.koide.kai.zisaku.databinding.ActivityMainBinding
import app.koide.kai.zisaku.databinding.ActivityQuizMainBinding


class QuizActivityMain : AppCompatActivity() {
    private lateinit var binding: ActivityQuizMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_main)



        binding = ActivityQuizMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        binding.Startbutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, TakeQuizActivity::class.java)
            startActivity(toSecondActivityIntent)

        }
        binding.quizhomebutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(toSecondActivityIntent)
        }


    }
}