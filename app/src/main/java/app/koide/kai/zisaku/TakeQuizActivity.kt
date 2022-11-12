package app.koide.kai.zisaku

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.koide.kai.zisaku.databinding.ActivityQuizBinding
import app.koide.kai.zisaku.databinding.QuizactivitymainBinding
import kotlinx.android.synthetic.main.activity_take_quiz.*
import org.json.JSONArray
import java.util.Collections
import java.util.Random

class TakeQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_quiz)

        binding = ActivityQuizBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        getWordList()


    }



    private fun getWordList(int: Int): List<Word> {
        val sharedPreferences = this.getSharedPreferences("test", Context.MODE_PRIVATE)

        val jsonArrayEn = JSONArray(sharedPreferences.getString("En", "[]"));
        val jsonArrayJP = JSONArray(sharedPreferences.getString("JP", "[]"));
        Collections.shuffle(jsonArrayEn);
        Collections.shuffle(jsonArrayJP);
        var n = 0
        return if (jsonArrayEn.length() == jsonArrayJP.length()) {
            buildList {
                for (i in 0 until jsonArrayEn.length()) {
                    add(
                        Word(
                            english = jsonArrayEn[i] as? String ?: return listOf(),
                            jp = jsonArrayJP[i] as? String ?: return listOf()
                        )
                    )
                }
                var r = Random().nextInt(4)
                button1.text = jsonArrayJP.get(n).toString()
                button2.text = jsonArrayJP.get(n+1).toString()
                button3.text = jsonArrayJP.get(n+2).toString()
                button4.text = jsonArrayJP.get(n+3).toString()
                wordtext.text =jsonArrayEn.get(n+r).toString()
                var n= n+4

            }
        }else listOf()
    }
}
//for (i in 0 until jsonArrayJP.length()) {
//            mutableListJP.add(jsonArrayJP.get(i) as String)
//            Log.i("loadListJP", "[$i] -> " + mutableListJP.get(i))
//        }