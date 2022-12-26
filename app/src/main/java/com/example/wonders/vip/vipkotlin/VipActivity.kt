package com.example.wonders.vip.vipkotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wonders.R
import com.example.wonders.databinding.ActivityVipBinding
import com.example.wonders.vip.trip.tripPlan

class VipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVipBinding.inflate(layoutInflater)

        binding.dests.dropDownVerticalOffset = 120
        val destList = listOf("Hangzhou", "Tianjin", "Sanya")
        val destAdapter = ArrayAdapter<String>(this, R.layout.spinner_item, destList)
        binding.dests.adapter = destAdapter

        binding.dests.onItemSelectedListener = DestSelector(binding.tripPlan, destList)

    }

    private class DestSelector(val tripPlanView: TextView, val destList: List<String>) : OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val planDetail = tripPlan(destList[position])
            tripPlanView.text = planDetail
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}
