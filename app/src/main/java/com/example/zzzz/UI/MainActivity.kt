package com.example.zzzz.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.zzzz.R
import com.example.zzzz.UI.Fragments.AlmacenamientoFragment
import com.example.zzzz.UI.Fragments.LocalFragment
import com.example.zzzz.UI.Fragments.RetrofitFragment
import com.example.zzzz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            bottonNavegation.menu.findItem(R.id.itmRetrofit).setOnMenuItemClickListener {
                PasarFragment(RetrofitFragment.newInstance())
                return@setOnMenuItemClickListener false
            }
            bottonNavegation.menu.findItem(R.id.itnmLocal).setOnMenuItemClickListener {
                PasarFragment(LocalFragment.newInstance())
                return@setOnMenuItemClickListener false
            }

            bottonNavegation.menu.findItem(R.id.itmAlmacenamiento).setOnMenuItemClickListener {
                PasarFragment(AlmacenamientoFragment.newInstance())
                return@setOnMenuItemClickListener false
            }
        }
    }


    private fun PasarFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
    }


}