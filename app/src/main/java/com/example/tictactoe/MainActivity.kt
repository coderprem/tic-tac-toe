package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var flag = 0
    val count = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(/* view = */ binding.root)

        binding.image.translationY = -1000f
        binding.textView.translationY = 1000f

        binding.image.animate().translationY(0f).duration = 1000
        binding.textView.animate().translationY(0f).duration = 1000

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }, 2500)
    }

    fun btnCheck(view: View){
        val btnCurrent = view as Button
        if (flag==0){
            btnCurrent.text = "X"
            flag = 1
        } else {
            btnCurrent.text = "O"
            flag = 0
        }
    }
}