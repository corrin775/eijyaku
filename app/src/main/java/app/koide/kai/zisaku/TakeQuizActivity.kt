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


    private var mutableListEn: MutableList<String> = mutableListOf()
    private var mutableListJP: MutableList<String> = mutableListOf()
    private var mutableListR: MutableList<Int> = mutableListOf()

    private var jsonArrayEn = JSONArray("""[""]""")
    private var jsonArrayJP = JSONArray("""[""]""")
    private var jsonArrayEx = JSONArray("""[""]""")

    private var q = 4
    private var counter = 0
    private var matu = 0
    private var right = 0

    private lateinit var binding: ActivityTakeQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_quiz)

        binding = ActivityTakeQuizBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        Log.i("loopcheack0","問題なし")
        val sharedPreferences = this.getSharedPreferences("test", Context.MODE_PRIVATE)

        jsonArrayEn = JSONArray(sharedPreferences.getString("En", "[]"));
        jsonArrayJP = JSONArray(sharedPreferences.getString("JP", "[]"));
        jsonArrayEx = JSONArray(sharedPreferences.getString("Ex", "[]"));

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
        mutableListR.shuffle()
        //Collections.shuffle(mutableListR)
        Log.i("mutable",mutableListR.toString())
        Question()

    }




    private fun Question() {
        val toSecondActivityIntent = Intent(this, ResultttActivity::class.java)

        var long = jsonArrayEn.length()
        Log.i("cheackQuestion","Question到達")
            //var n = counter*4
        var Ia = counter*4 % long
        var Ib = (counter*4 + 1)%long
        var Ic = (counter*4 + 2)%long
        var Id = (counter*4 + 3)%long
        var r = (0..3).random()
        var Ir = (counter*4 + r)%long
            var a = mutableListR.get(Ia)
            //Log.i("cheackword1",mutableListR.get(Ia))
            var b = mutableListR.get(Ib)
            //Log.i("cheackword2",mutableListR.get((counter*4+1)%long).toString())
            var c = mutableListR.get(Ic)
             //Log.i("cheackword3",mutableListR.get((counter*4+2)%long).toString())
            var d = mutableListR.get(Id)
            //Log.i("cheackword",mutableListR.get((n+4)%m).toString())
            var e = mutableListR.get(Ir)
        Log.i("cheackQuestion","問題出題")
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
                    right++
                }
                binding.judgeView.isVisible = true
                binding.nextbutton.isVisible = true
                binding.answertext.isVisible = true
            }
            binding.button2.setOnClickListener {
                if (binding.answertext.text == binding.button2.text) {
                    binding.judgeView.setImageResource(R.drawable.maru_image)
                    right++
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
                    right++
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
                    right++
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

                        toSecondActivityIntent.putExtra("Qcount",(q+1).toString())
                        toSecondActivityIntent.putExtra("Rcount",right.toString())
                        startActivity(toSecondActivityIntent)
                    }else {
                        binding.judgeView.isVisible = false
                        binding.nextbutton.isVisible = false
                        binding.answertext.isVisible = false
                        counter++
                        Question()
                    }
                }

    }
    //fun Syutudai(){

    //}
}

