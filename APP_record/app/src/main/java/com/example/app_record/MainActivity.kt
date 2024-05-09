package com.example.app_record

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_record.com.example.app_record.RecordAdapter
import com.example.app_record.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: RecordAdapter
    private var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.toolbarMain.inflateMenu(R.menu.menu)
        mAdapter = RecordAdapter(this, Bprecords(emptyList()))
        binding.recordRecycler.adapter = mAdapter
        binding.recordRecycler.layoutManager = LinearLayoutManager(this)
        val records = Bprecords(
            mutableListOf(
                bprecord("2024-05-09 10:00", 120, 80, 72),
                bprecord("2024-05-09 14:00", 125, 82, 75),
                bprecord("2024-05-09 10:00", 118, 78, 70)
            )
        )

        mAdapter.updateData(records)


}
override fun onContextItemSelected(item: MenuItem): Boolean {
    //return super.onContextItemSelected(item)
    val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
    return when (item.itemId) {
        R.id.menu_add -> {

            return true
        }
        else -> super.onContextItemSelected(item)

        /*binding.toolbarMain.setOnMenuItemClickListener{
    when(it.itemId){
        R.id.menu_add ->{
            Log.e(TAG,"Menu_add")

            true
        }
    }
    true*/
    }
}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_ CODE_ADD_RECORD && resultCode == Activity.RESULT_OK){
            val sys = data?.getIntExtra("sys",0)?:0
            val dia = data?.getIntExtra("dia",0)?:0
            val hr = data?.getIntExtra("hr",0)?:0
            val newRecord = Brecord(getCurrentDateTime(),sys,dia,hr)

            mAdapter.addRecord(newRecord)
    }
}

    fun getCurrentDateTime():String{
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return current.format(formatter)

    }    }

