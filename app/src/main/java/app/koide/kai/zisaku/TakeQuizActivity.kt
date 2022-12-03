package app.koide.kai.zisaku

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import app.koide.kai.zisaku.databinding.ActivityQuizBinding
import app.koide.kai.zisaku.databinding.ActivityTakeQuizBinding
import app.koide.kai.zisaku.databinding.QuizactivitymainBinding
import kotlinx.android.synthetic.main.activity_take_quiz.*
import org.json.JSONArray
import java.util.Collections
import java.util.Random

class TakeQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTakeQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_quiz)

        binding = ActivityTakeQuizBinding.inflate(layoutInflater).apply { setContentView(this.root) }


        TotakeList()


    }




    private fun TotakeList() {
        val sharedPreferences = this.getSharedPreferences("test", Context.MODE_PRIVATE)

        var mutableListEn: MutableList<String> = mutableListOf()
        var mutableListJP: MutableList<String> = mutableListOf()
        var mutableListR: MutableList<Int> = mutableListOf()

        val jsonArrayEn = JSONArray(sharedPreferences.getString("En", "[]"));
        val jsonArrayJP = JSONArray(sharedPreferences.getString("JP", "[]"));
        val jsonArrayEx = JSONArray(sharedPreferences.getString("Ex", "[]"));


        for (i in 0 until jsonArrayEn.length()) {
            mutableListEn.add(jsonArrayEn.get(i) as String)
            Log.i("loadListEn", "[$i] -> " + mutableListEn.get(i))
        }
        for (i in 0 until jsonArrayJP.length()) {
            mutableListJP.add(jsonArrayJP.get(i) as String)
            Log.i("loadListJP", "[$i] -> " + mutableListJP.get(i))
        }

        for (i in 0 until jsonArrayJP.length()) {
            mutableListR.add(i)

        }

        Collections.shuffle(mutableListR)

        var z = 10
        for (i in 0..z){
            var n = i*4
            var a = mutableListR.get((n+1)%z)
            var b = mutableListR.get((n+2)%z)
            var c = mutableListR.get((n+3)%z)
            var d = mutableListR.get((n+4)%z)
            var r = Random().nextInt(4)
            var e = mutableListR.get((n+r)%z)

            binding.button1.text = mutableListJP.get(a).toString()
            binding.button2.text = mutableListJP.get(b).toString()
            binding.button3.text = mutableListJP.get(c).toString()
            binding.button4.text = mutableListJP.get(d).toString()
            binding.wordtext.text = mutableListEn.get(e).toString()

            binding.answertext.text = mutableListJP.get(e)
            binding.button1.setOnClickListener{
                if (binding.answertext.text == binding.button1.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                } else {
                    binding.judgeView.setImageResource(R.drawable.batu_image)
                }
                binding.judgeView.isVisible  =true
                binding.nextbutton.isVisible  =true
                binding.answertext.isVisible  =true
            }
            binding.button2.setOnClickListener {
                if (binding.answertext.text == binding.button2.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                } else {
                    binding.judgeView.setImageResource(R.drawable.batu_image)
                }
                binding.judgeView.isVisible  =true
                binding.nextbutton.isVisible  =true
                binding.answertext.isVisible  =true
            }
            binding.button3.setOnClickListener{
                if (binding.answertext.text == binding.button3.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                } else {
                    binding.judgeView.setImageResource(R.drawable.batu_image)
                }
                binding.judgeView.isVisible  =true
                binding.nextbutton.isVisible  =true
                binding.answertext.isVisible  =true
            }
            binding.button4.setOnClickListener{
                if (binding.answertext.text == binding.button4.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                } else {
                    binding.judgeView.setImageResource(R.drawable.batu_image)
                }
                binding.judgeView.isVisible  =true
                binding.nextbutton.isVisible  =true
                binding.answertext.isVisible  =true

            }
            binding.nextbutton.setOnClickListener {
                if(i==z){
                    val toSecondActivityIntent = Intent(this, ResultActivity::class.java)
                    startActivity(toSecondActivityIntent)
                }else{
                    binding.judgeView.isVisible  =false
                    binding.nextbutton.isVisible  =false
                    binding.answertext.isVisible  =false
                }
            }
        }
    }
}

