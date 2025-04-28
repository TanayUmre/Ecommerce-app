package com.example.giftkart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.giftkart.R

class ProductDetailsFragment : Fragment() {

    private val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product_details, container, false)

        // Retrieve the product ID passed as an argument
        val productId = args.productId

        // TODO: Fetch product details using productId and update the UI

        return view
    }
}