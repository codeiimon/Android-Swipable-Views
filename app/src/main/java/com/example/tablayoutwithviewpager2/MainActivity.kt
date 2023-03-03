package com.example.tablayoutwithviewpager2

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayoutwithviewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var img = listOf<Int>(
            R.drawable.calendarpack1,
            R.drawable.calendarpack2,
            R.drawable.calendarpack4,
            R.drawable.calendarpack5
        )

        binding.viewPager2.adapter = ViewPager2Adapter(img)


        fun getResFileName (id: Int) : String {
            val resIdURI = resources.getString(id)

            Log.d("TAG", "Value String:" + resIdURI);
            var filename = resIdURI.substring(resIdURI.lastIndexOf("/")+1)
            Log.d("TAG", "Resource filename:" + filename);
            return filename
        }

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = getResFileName(img[position])
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "ReSelected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}