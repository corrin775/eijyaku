package app.koide.kai.zisaku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.koide.kai.zisaku.databinding.ActivityQuizBinding
import app.koide.kai.zisaku.databinding.QuizactivitymainBinding

class TakeQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_quiz)

        binding = ActivityQuizBinding.inflate(layoutInflater).apply { setContentView(this.root) }
    }
}