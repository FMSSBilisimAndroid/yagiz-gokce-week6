package com.yagizgokce.bootcamp_week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counter = 0
        while(true) {
            CoroutineScope(Dispatchers.IO).launch {
                val answer = doNetworkCall()
                withContext(Dispatchers.Main) {
                    Log.v("PATIKA",answer)
                }
            }
            counter++
            println("Counter : $counter")
        }
    }
    private suspend fun doNetworkCall():String {
        delay(1000)
        return "Network Call Answer"
    }
}