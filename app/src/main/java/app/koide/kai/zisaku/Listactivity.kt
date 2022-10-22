package app.koide.kai.zisaku

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import app.koide.kai.zisaku.databinding.ActivityListactivityBinding
import app.koide.kai.zisaku.databinding.ActivityMainBinding
import layout.WordAdapter
import org.json.JSONArray
import java.lang.Exception
import java.text.FieldPosition

class Listactivity : AppCompatActivity() {
    private lateinit var binding: ActivityListactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listactivity)
        binding =
            ActivityListactivityBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        binding.homebutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(toSecondActivityIntent)
        }
        binding.plusbutton.setOnClickListener {
            val toSecondActivityIntent = Intent(this, Addwordactivity::class.java)
            startActivity(toSecondActivityIntent)
        }
        //loadAll("String")

        //testEn("En")



        val adapter = WordAdapter(
            onClickCellListener = object : WordAdapter.OnCellClickListener {
                override fun onCLick(position: Int) {
                    val nextIntent = Intent(this@Listactivity, WordExpianationactivity::class.java)

                    nextIntent.putExtra("POSITION", position)
                    startActivity(nextIntent)
                }
            }
        )
        adapter.updateWordList(getWordList())


        binding.recycler.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recycler.layoutManager = layoutManager


    }

    private fun getWordList(): List<Word> {
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
            }
            }else listOf()
    }

/*
    fun loadAll(key: String){
        val sharedPreferences = this.getSharedPreferences("test", Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()

        val jsonArrayEn = JSONArray(sharedPreferences.getString("En", "[]"));
        val jsonArrayJP = JSONArray(sharedPreferences.getString("JP", "[]"));

        val Entext = TextView(this)
        val JPtext = TextView(this)

        var mutableListEn: MutableList<String> = mutableListOf()
        var mutableListJP: MutableList<String> = mutableListOf()

        Log.i("debug", "load all class")


    try {
        for (i in 0 until jsonArrayEn.length()) {
        mutableListEn.add(jsonArrayEn.get(i) as String)
        Log.i("loadListEn", "[$i] -> " + mutableListEn.get(i))
        Log.i("CHECK HERE", i.toString())
        }
        for (i in 0 until jsonArrayJP.length()) {
            mutableListJP.add(jsonArrayJP.get(i) as String)
            Log.i("loadListJP", "[$i] -> " + mutableListJP.get(i))
        }
0
    }catch (e: Exception){
        Log.i("try catch", "for loop error")

    }




        for (i in 0 until jsonArrayEn.length()) {
            Entext.text = mutableListEn.get(i) as String
            Entext.textSize = 10.0f
            Log.i("TEST", Entext.toString())

            JPtext.text = mutableListJP.get(i) as String
            JPtext.textSize = 10.0f

            val layout = LinearLayout(this)
            layout.orientation = LinearLayout.HORIZONTAL
            layout.addView(Entext)
            layout.addView(JPtext)

            val lp = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            lp.gravity = Gravity.CENTER_VERTICAL
            Entext.layoutParams = lp
            JPtext.layoutParams = lp

            binding.container.addView(layout)
        }
    }

    fun testEn(key: String){
        var mutableListEn: MutableList<String> = mutableListOf()
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        val jsonArrayEn = JSONArray(sharedPreferences.getString("En", "[]"));
        /*for (i in 0 until jsonArrayEn.length()) {
            mutableListEn.add(jsonArrayEn.get(i) as String)
            Log.i("loadListEn", "[$i] -> " + mutableListEn.get(i))
        }
        
         */
        binding.test.text = mutableListEn[1].toString()
        Log.i("CHECK", mutableListEn[1].toString())

    }

 */
}