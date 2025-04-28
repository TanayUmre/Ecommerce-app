package com.example.giftkart.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.giftkart.R
import com.example.giftkart.adapters.HomeViewpagerAdapter
import com.example.giftkart.databinding.FragmentHomeBinding
import com.example.giftkart.fragments.categories.BagsFragment
import com.example.giftkart.fragments.categories.DrinkwareFragment
import com.example.giftkart.fragments.categories.MainCategoryFragment
import com.example.giftkart.fragments.categories.StationaryFragment
import com.example.giftkart.fragments.categories.TechFragment
import com.example.giftkart.fragments.categories.WearableFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment(R.layout.fragment_home){
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container:ViewGroup?,
        savedInstanceState:Bundle?
    ): View?{
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            StationaryFragment(),
            TechFragment(),
            WearableFragment(),
            DrinkwareFragment(),
            BagsFragment()
        )

        val viewPager2Adapter = HomeViewpagerAdapter(categoriesFragments,childFragmentManager,lifecycle)
        binding.viewpagerHome.adapter=viewPager2Adapter
        TabLayoutMediator(binding.tabLayout,binding.viewpagerHome) { tab, position ->
            when(position){
                0-> {
                    tab.text = "Main"
                    tab.contentDescription = "Main Category"
                }
                1-> {
                    tab.text = "Stationary"
                    tab.contentDescription = "Stationary Category"
                }
                2-> {
                    tab.text = "Tech"
                    tab.contentDescription = "Tech Category"
                }
                3-> {
                    tab.text = "Wearable"
                    tab.contentDescription = "Wearable Category"
                }
                4-> {
                    tab.text = "Drinkware"
                    tab.contentDescription = "Drinkware Category"
                }
                5-> {
                    tab.text = "Bags/Sleeve"
                    tab.contentDescription = "Bags/Sleeve Category"
                }
            }
        }.attach()
    }
}