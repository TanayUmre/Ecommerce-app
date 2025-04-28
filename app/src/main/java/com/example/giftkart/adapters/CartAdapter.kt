package com.example.giftkart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.giftkart.R
import com.example.giftkart.data.CartItem
import com.example.giftkart.databinding.CartItemBinding

class CartAdapter(
    private val onRemoveItem: (CartItem) -> Unit,
    private val onQuantityChanged: (CartItem, Int) -> Unit
) : ListAdapter<CartItem, CartAdapter.CartViewHolder>(CartDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = getItem(position)
        holder.bind(cartItem)
    }

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cartItem: CartItem) {
            binding.apply {
                // Access properties from the Product object in CartItem
                tvProductName.text = cartItem.product.name
                tvProductPrice.text = root.context.getString(R.string.price, cartItem.product.price)
                etQuantity.setText(cartItem.quantity.toString())

                // Remove item button action
                btnRemove.setOnClickListener {
                    onRemoveItem(cartItem)
                }

                // Quantity change listener
                etQuantity.setOnFocusChangeListener { _, hasFocus ->
                    if (!hasFocus) {
                        val newQuantity = etQuantity.text.toString().toIntOrNull() ?: cartItem.quantity
                        if (newQuantity != cartItem.quantity) {
                            onQuantityChanged(cartItem, newQuantity)
                        }
                    }
                }
            }
        }
    }

    private class CartDiffCallback : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            // Compare the IDs of the products inside the CartItem
            return oldItem.product.id == newItem.product.id
        }

        override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            // Compare the entire CartItem object for content equality
            return oldItem == newItem
        }
    }
}