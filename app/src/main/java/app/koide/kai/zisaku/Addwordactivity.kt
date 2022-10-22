package app.koide.kai.zisaku

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.koide.kai.zisaku.databinding.ActivityAddwordactivityBinding
import app.koide.kai.zisaku.databinding.ActivityListactivityBinding
import kotlinx.android.synthetic.main.activity_addwordactivity.*
import kotlinx.android.synthetic.main.activity_listactivity.*
import org.json.JSONArray

class Addwordactivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddwordactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addwordactivity)
        binding = ActivityAddwordactivityBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        savebutton.setOnClickListener {
            loadAndSaveListEn("En")
            loadAndSaveListJP("JP")
            loadAndSaveListEx("Ex")

            val toSecondActivityIntent = Intent(this, Listactivity::class.java)
            startActivity(toSecondActivityIntent)
        }
    }

    fun loadAndSaveListEn(key: String){
        var mutableListEn: MutableList<String> = mutableListOf()
        val sharedPreferences = this.getSharedPreferences("test", Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()

        val jsonArrayEn = JSONArray(sharedPreferences.getString("En", "[]"));

        for (i in 0 until jsonArrayEn.length()) {
            mutableListEn.add(jsonArrayEn.get(i) as String)
            Log.i("loadListEn", "[$i] -> " + mutableListEn.get(i))
        }

        mutableListEn.add(binding.putEnglish.text.toString())

        //saveListEn("En",mutableListEn)
        val JAupEn = JSONArray(mutableListEn)
        sharedPrefEditor.putString("En", JAupEn.toString())
        sharedPrefEditor.apply()

    }

    fun loadAndSaveListJP(key: String){
        var mutableListJP: MutableList<String> = mutableListOf()
        val sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()

        val jsonArrayJP = JSONArray(sharedPreferences.getString("JP", "[]"));

        for (i in 0 until jsonArrayJP.length()) {
            mutableListJP.add(jsonArrayJP.get(i) as String)
            Log.i("loadListJP", "[$i] -> " + mutableListJP.get(i))
        }

        mutableListJP.add(binding.putJP.text.toString())

        //saveListJP("JP",mutableListJP)

       // saveListJP("JP",mutableListJP)
        val JAupJP = JSONArray(mutableListJP)
        sharedPrefEditor.putString("JP", JAupJP.toString())
        sharedPrefEditor.apply()


    }

    fun loadAndSaveListEx(key: String){
        var mutableListEx: MutableList<String> = mutableListOf()
        val sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()

        val jsonArrayEx = JSONArray(sharedPreferences.getString("Ex", "[]"));

        for (i in 0 until jsonArrayEx.length()) {
            mutableListEx.add(jsonArrayEx.get(i) as String)
            Log.i("loadListEx", "[$i] -> " + mutableListEx.get(i))
        }

        mutableListEx.add(binding.putEx.text.toString())

        //saveListEx("Ex",mutableListEx)

        //saveListEx("Ex",mutableListEx)
        val JAupEx = JSONArray(mutableListEx)
        sharedPrefEditor.putString("Ex", JAupEx.toString())
        sharedPrefEditor.apply()


    }


    fun saveListEn(key: String, mutableListEn: MutableList<String>){
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()

        val jsonArrayEn = JSONArray(mutableListEn)
        sharedPrefEditor.putString(key, jsonArrayEn.toString())

        sharedPrefEditor.apply()
    }
    fun loadListEn(key: String) {

        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        val jsonArrayEn = JSONArray(sharedPreferences.getString(key, "[]"));

        for (i in 0 until jsonArrayEn.length()) {
            Log.i("loadListEn", "[$i] -> " + jsonArrayEn.get(i))

        }

    }

    fun saveListJP(key: String, mutableListJP: MutableList<String>){
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()

        val jsonArrayJP = JSONArray(mutableListJP)
        sharedPrefEditor.putString(key, jsonArrayJP.toString())
        sharedPrefEditor.apply()
    }
    fun loadListJP(key: String) {

        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        val jsonArrayJP = JSONArray(sharedPreferences.getString(key, "[]"));

        for (i in 0 until jsonArrayJP.length()) {
            Log.i("loadListJP", "[$i] -> " + jsonArrayJP.get(i))
        }
    }

    fun saveListEx(key: String, mutableListEx: MutableList<String>){
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()

        val jsonArrayEx = JSONArray(mutableListEx)
        sharedPrefEditor.putString(key, jsonArrayEx.toString())
        sharedPrefEditor.apply()
    }
    fun loadListEx(key: String) {

        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        val jsonArrayEx = JSONArray(sharedPreferences.getString(key, "[]"));

        for (i in 0 until jsonArrayEx.length()) {
            Log.i("loadListEx", "[$i] -> " + jsonArrayEx.get(i))
        }
    }







}