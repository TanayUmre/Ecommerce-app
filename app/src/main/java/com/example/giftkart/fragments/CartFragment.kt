package com.example.giftkart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.giftkart.R
import com.example.giftkart.adapters.CartAdapter
import com.example.giftkart.databinding.FragmentCartBinding
import com.example.giftkart.viewmodel.CartViewModel

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private val cartViewModel: CartViewModel by activityViewModels()
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeCartItems()
        observeTotalPrice()
    }

    private fun setupRecyclerView() {
        // Initialize CartAdapter with proper lambdas
        cartAdapter = CartAdapter(
            onRemoveItem = { cartItem ->
                cartViewModel.removeItemFromCart(cartItem)
            },
            onQuantityChanged = { cartItem, newQuantity ->
                cartViewModel.updateItemQuantity(cartItem, newQuantity)
            }
        )

        // Set up RecyclerView
        binding.recyclerViewCart.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cartAdapter
        }
    }

    private fun observeCartItems() {
        cartViewModel.cartItems.observe(viewLifecycleOwner, Observer { cartItems ->
            cartAdapter.submitList(cartItems)
        })
    }

    private fun observeTotalPrice() {
        cartViewModel.totalPrice.observe(viewLifecycleOwner, Observer { totalPrice ->
            binding.textViewTotalPrice.text = getString(R.string.total_price, totalPrice)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}