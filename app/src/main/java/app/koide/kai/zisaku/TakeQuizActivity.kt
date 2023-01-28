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
        var q = 4
        // Log.i("loopcheack","問題なし")
        var counter = 0
        var long = jsonArrayEn.length()
        var matu = 0
        Question(matu)


    }




    private fun Question(x=matu) {
            //var n = counter*4
            var a = mutableListR.get(((counter*4 + 1) % long)-1)
            //Log.i("cheackword",mutableListR.get((n+1)%m).toString())
            var b = mutableListR.get(((counter*4 + 2) % long)-1)
            // Log.i("cheackword",mutableListR.get((n+2)%m).toString())
            var c = mutableListR.get(((counter*4 + 3) % long)-1)
            // Log.i("cheackword",mutableListR.get((n+3)%m).toString())
            var d = mutableListR.get(((counter*4 + 4) % long)-1)
            //Log.i("cheackword",mutableListR.get((n+4)%m).toString())
            var r = Random().nextInt(4)
            var e = mutableListR.get(((counter*4 + r) % long)-1)

        //選択肢を呼び出す
            binding.button1.text = mutableListJP.get(a).toString()
            binding.button2.text = mutableListJP.get(b).toString()
            binding.button3.text = mutableListJP.get(c).toString()
            binding.button4.text = mutableListJP.get(d).toString()
        //出題する単語（英語）を呼び出す
            binding.wordtext.text = mutableListEn.get(e).toString()
        //出題した単語の日本語訳を呼び出す
            binding.answertext.text = mutableListJP.get(e)
            //Log.i("loopcheack2","問題なし")




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
                    if (counter==q){
                        val toSecondActivityIntent = Intent(this, ResultActivity::class.java)
                        startActivity(toSecondActivityIntent)
                    }else {
                        binding.judgeView.isVisible = false
                        binding.nextbutton.isVisible = false
                        binding.answertext.isVisible = false
                        //var test2 = test2+1
                        //Log.i("nextbutton", "" + n)
                        counter++
                        var a = mutableListR.get(((counter*4 + 1) % long)-1)
                        //Log.i("cheackword",mutableListR.get((n+1)%m).toString())
                        var b = mutableListR.get(((counter*4 + 2) % long)-1)
                        // Log.i("cheackword",mutableListR.get((n+2)%m).toString())
                        var c = mutableListR.get(((counter*4 + 3) % long)-1)
                        // Log.i("cheackword",mutableListR.get((n+3)%m).toString())
                        var d = mutableListR.get(((counter*4 + 4) % long)-1)
                        //Log.i("cheackword",mutableListR.get((n+4)%m).toString())
                        var r = Random().nextInt(4)
                        var e = mutableListR.get(((counter*4 + r) % long)-1)

                        Log.i("loop", "")
                        //選択肢を呼び出す
                        binding.button1.text = mutableListJP.get(a).toString()
                        binding.button2.text = mutableListJP.get(b).toString()
                        binding.button3.text = mutableListJP.get(c).toString()
                        binding.button4.text = mutableListJP.get(d).toString()
                        //出題する単語（英語）を呼び出す
                        binding.wordtext.text = mutableListEn.get(e).toString()
                        //出題した単語の日本語訳を呼び出す
                        binding.answertext.text = mutableListJP.get(e)
                        //Log.i("loopcheack2","問題なし")

                    }
                }

    }
    //fun Syutudai(){

    //}
}

