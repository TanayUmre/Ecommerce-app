package com.example.giftkart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giftkart.R
import com.example.giftkart.adapters.ProductAdapter
import com.example.giftkart.data.ProductRepository

class ProductListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        val products = ProductRepository.getProductsByCategory("Bags")

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewProducts)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = ProductAdapter(products) { product ->
            // Navigate to ProductDetailsFragment with product ID as argument
            val action =
                ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(
                    product.id
                )
            findNavController().navigate(action)
        }

        return view
    }
}