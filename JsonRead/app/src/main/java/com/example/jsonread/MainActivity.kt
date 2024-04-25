package com.example.jsonread

import android.media.AudioPlaybackCaptureConfiguration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.ActionBarContextView
import com.google.gson.Gson
import java.net.URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONObject
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(),CoroutineScope{


    val TAG = MainActivity::class.java.simpleName
    val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Thread(){
            val json = URL("https://api.jsonserve.com/KizxuV").readText()
            Log.w(TAG,json)
        }.start()*/

        launch{
            val json = URL("https://api.jsonserve.com/KizxuV").readText()
            Log.w(TAG,json)
            //parseJson(json)
            val singers = Gson().fromJson(json, Singers::class.java)
            for(w in singers.singers){
                Log.d(TAG,"onCreate: ${w.name}, ${w.agency}, ${w.year_of_debut}")
            }
        }

    }

    private fun parseJson(json: String) {
        val jsonObject = JSONObject(json)
        val array = jsonObject.getJSONArray("singers")
        for (i in 0..array.length() - 1) {
            val w = array.getJSONObject(i)
            val name = w.getString("name")
            val agency = w.getString("agency")
            Log.d(TAG, "onCreate: $name : $agency")
        }
    }


}