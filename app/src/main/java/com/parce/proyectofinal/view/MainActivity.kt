package com.parce.proyectofinal.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.parce.proyectofinal.R
import com.parce.proyectofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.stringCompare.observe(this){
            setResultText(it.compareResult)
        }

        binding.btnCompare.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
            val str1: String = binding.etTextA.text.toString()
            val str2: String = binding.etTextB.text.toString()
            mainViewModel.compareStrings(str1,str2)
        }
    }

    fun setResultText(compResult: Boolean){
        binding.tvResult.text = if (compResult) getString(R.string.compareOk) else  getString(R.string.compareFail)
    }
}