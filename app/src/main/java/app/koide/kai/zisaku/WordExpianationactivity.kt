package app.koide.kai.zisaku

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.koide.kai.zisaku.databinding.ActivityWordExpianationactivityBinding
import kotlinx.android.synthetic.main.activity_addwordactivity.*
import kotlinx.android.synthetic.main.activity_word_expianationactivity.*
import org.json.JSONArray

class WordExpianationactivity : AppCompatActivity() {
    private lateinit var binding: ActivityWordExpianationactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {4
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_expianationactivity)

        binding = ActivityWordExpianationactivityBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        binding.backbutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, Listactivity::class.java)
            startActivity(toSecondActivityIntent)
        }
        val int: Int = intent.getIntExtra("POSITION",-1)

        //binding.EXputEnglishView.text = getWordList()

        getWordList(int)



        /*
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        savebutton.setOnClickListener {
            //"Input"から詠みだす
            val str = dataStore.getString("Input","NOdata")
            EXputEnglishView.text = str
        }
        savebutton.setOnClickListener {
            //"Input"から詠みだす
            val str = dataStore.getString("Input1","NOdata")
            EXputJPView.text = str
        }
        savebutton.setOnClickListener {
            //"Input"から詠みだす
            val str = dataStore.getString("Input2","NOdata")
            EXputexplanationView.text = str
        }

         */
    }
    private fun getWordList(int: Int): List<Word> {
        val sharedPreferences = this.getSharedPreferences("test", Context.MODE_PRIVATE)

        val jsonArrayEn = JSONArray(sharedPreferences.getString("En", "[]"));
        val jsonArrayJP = JSONArray(sharedPreferences.getString("JP", "[]"));
        val jsonArrayEx = JSONArray(sharedPreferences.getString("Ex", "[]"));
        return if (jsonArrayEn.length() == jsonArrayJP.length()) {
            buildList {
                for (i in 0 until jsonArrayEn.length()) {
                    add(
                        Word(
                            english = jsonArrayEn[i] as? String ?: return listOf(),
                            jp = jsonArrayJP[i] as? String ?: return listOf(),
                            explanation = jsonArrayEx[i] as? String ?: return listOf(),
                        )
                    )
                }

                binding.EXputEnglishView.text = jsonArrayEn[int].toString()
                binding.EXputJPView.text = jsonArrayJP[int].toString()
                binding.EXputexplanationView.text = jsonArrayEx[int].toString()


            }
        }else listOf()
    }
}