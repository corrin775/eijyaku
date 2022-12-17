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
import kotlin.math.log

class TakeQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTakeQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_quiz)

        binding = ActivityTakeQuizBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        Log.i("loopcheack0","問題なし")
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
        var q = 11
        val test = q+1
       // Log.i("loopcheack","問題なし")
        var test2 = 0
        var m = jsonArrayEn.length()



        if (test2<q) {
            var n = test2 * 4
            var a = mutableListR.get((n + 1) % m)
            //Log.i("cheackword",mutableListR.get((n+1)%m).toString())
            var b = mutableListR.get((n + 2) % m)
            // Log.i("cheackword",mutableListR.get((n+2)%m).toString())
            var c = mutableListR.get((n + 3) % m)
            // Log.i("cheackword",mutableListR.get((n+3)%m).toString())
            var d = mutableListR.get((n + 4) % m)
            //Log.i("cheackword",mutableListR.get((n+4)%m).toString())
            var r = Random().nextInt(4)
            var e = mutableListR.get((n + r) % m)

            binding.button1.text = mutableListJP.get(a).toString()
            binding.button2.text = mutableListJP.get(b).toString()
            binding.button3.text = mutableListJP.get(c).toString()
            binding.button4.text = mutableListJP.get(d).toString()
            binding.wordtext.text = mutableListEn.get(e).toString()

            //Log.i("loopcheack2","問題なし")
            binding.answertext.text = mutableListJP.get(e)
            binding.button1.setOnClickListener {
                if (binding.answertext.text == binding.button1.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                } else {
                    binding.judgeView.setImageResource(R.drawable.batu_image)
                }
                binding.judgeView.isVisible = true
                binding.nextbutton.isVisible = true
                binding.answertext.isVisible = true
            }
            binding.button2.setOnClickListener {
                if (binding.answertext.text == binding.button2.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                } else {
                    binding.judgeView.setImageResource(R.drawable.batu_image)
                }
                binding.judgeView.isVisible = true
                binding.nextbutton.isVisible = true
                binding.answertext.isVisible = true
            }
            binding.button3.setOnClickListener {
                if (binding.answertext.text == binding.button3.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                } else {
                    binding.judgeView.setImageResource(R.drawable.batu_image)
                }
                binding.judgeView.isVisible = true
                binding.nextbutton.isVisible = true
                binding.answertext.isVisible = true
            }
            binding.button4.setOnClickListener {
                if (binding.answertext.text == binding.button4.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                } else {
                    binding.judgeView.setImageResource(R.drawable.batu_image)
                }
                binding.judgeView.isVisible = true
                binding.nextbutton.isVisible = true
                binding.answertext.isVisible = true
            }
            Log.i("loopcheack3", "loopのラスト")


            binding.nextbutton.setOnClickListener {

                binding.judgeView.isVisible = false
                binding.nextbutton.isVisible = false
                binding.answertext.isVisible = false
                var test2 = test2+1
                Log.i("nextbutton", "" + n)
            }
        }else{
            val toSecondActivityIntent = Intent(this, ResultActivity::class.java)
            startActivity(toSecondActivityIntent)
        }
    }
}

