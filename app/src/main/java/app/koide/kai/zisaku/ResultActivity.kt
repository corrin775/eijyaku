package app.koide.kai.zisaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.koide.kai.zisaku.databinding.ActivityResultBinding
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("cheackresuit", "到達")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)



        binding = ActivityResultBinding.inflate(layoutInflater).apply { setContentView(this.root) }




    }
}