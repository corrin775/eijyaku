package app.koide.kai.zisaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.koide.kai.zisaku.databinding.ActivityMainBinding
import app.koide.kai.zisaku.databinding.ActivityResultBinding
import app.koide.kai.zisaku.databinding.ActivityResultttBinding
import app.koide.kai.zisaku.databinding.ActivityTakeQuizBinding

class ResultttActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultttBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resulttt)
        binding = ActivityResultttBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        //binding.textView2.text = "test"

        val Qcount =intent?.getStringExtra("Qcount").toString()
        //Log.i("cheackresuit", Qcount.toString())
        //var Qcount2 = Qcount.toInt()+1
        binding.quizcount.text = Qcount
        //QcountView.setText(Qcount);
        //binding.QcountView.text = intent?.getStringExtra("Qcount").toString()

        val rightcount =intent?.getStringExtra("Rcount").toString()
        binding.rightcount.text = rightcount.toString()

        binding.gohomebutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, QuizActivityMain::class.java)
            startActivity(toSecondActivityIntent)
        }
        binding.tobebutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, TakeQuizActivity::class.java)
            startActivity(toSecondActivityIntent)
        }
    }
}