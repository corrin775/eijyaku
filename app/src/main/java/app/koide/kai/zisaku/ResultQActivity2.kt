package app.koide.kai.zisaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.koide.kai.zisaku.databinding.ActivityResultQactivity2Binding

class ResultQActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityResultQactivity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_qactivity2)
        binding = ActivityResultQactivity2Binding.inflate(layoutInflater).apply { setContentView(this.root) }

        val Qcount =intent.getStringExtra("Qcount").toString()
        Log.i("cheackresuit", Qcount.toString())
        binding.qcountView2.text = "Qcountttttttttttttt"
        //QcountView.setText(Qcount);
        //binding.QcountView.text = intent?.getStringExtra("Qcount").toString()

        val rightcount =intent.getStringExtra("Rcount").toString()
        binding.countanswer2.text = rightcount.toString()

        binding = ActivityResultQactivity2Binding.inflate(layoutInflater).apply { setContentView(this.root) }
        binding.buckbutton3.setOnClickListener {
            val toSecondActivityIntent = Intent(this, QuizActivityMain::class.java)
            startActivity(toSecondActivityIntent)
        }
        binding.continuebutton3.setOnClickListener {
            val toSecondActivityIntent = Intent(this, TakeQuizActivity::class.java)
            startActivity(toSecondActivityIntent)
        }

    }
}