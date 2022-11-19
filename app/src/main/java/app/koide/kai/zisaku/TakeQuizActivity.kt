package app.koide.kai.zisaku

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        var Int = intent.getIntArrayExtra()
        Collections.shuffle(int);

        //Log.i("TEST", mutableListJP.get(0))

        var c = 0
        var r = Random().nextInt(4)
        binding.button1.text = mutableListJP.get(0).toString()
        binding.button2.text = mutableListJP.get(1).toString()
        binding.button3.text = mutableListJP.get(2).toString()
        binding.button4.text = mutableListJP.get(3).toString()
        binding.wordtext.text = mutableListEn.get(c).toString()
        c = c + 1
    }
}
