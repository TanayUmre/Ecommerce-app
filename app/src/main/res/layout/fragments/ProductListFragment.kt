package com.example.giftkart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giftkart.R
import com.example.giftkart.data.ProductRepository

class ProductListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment layout
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        // Fetch the products by category (hardcoding "Bags" category here for demonstration)
        val products = ProductRepository.getProductsByCategory("Bags")

        // Set up RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewProducts)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2) // 2-column grid
        recyclerView.adapter = ProductAdapter(products) { product ->
            // Handle product click (e.g., navigate to ProductDetailsFragment)
            // TODO: Add navigation to ProductDetailsFragment
        }

        return view
    }
}