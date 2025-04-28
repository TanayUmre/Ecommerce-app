package com.example.giftkart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giftkart.data.CartItem

class CartViewModel : ViewModel() {

    private val _cartItems = MutableLiveData<List<CartItem>>(emptyList())
    val cartItems: LiveData<List<CartItem>> get() = _cartItems

    private val _totalPrice = MutableLiveData<Double>(0.0)
    val totalPrice: LiveData<Double> get() = _totalPrice

    fun addItemToCart(cartItem: CartItem) {
        val updatedCart = _cartItems.value!!.toMutableList()
        updatedCart.add(cartItem)
        _cartItems.value = updatedCart
        calculateTotalPrice()
    }

    fun removeItemFromCart(cartItem: CartItem) {
        val updatedCart = _cartItems.value!!.toMutableList()
        updatedCart.remove(cartItem)
        _cartItems.value = updatedCart
        calculateTotalPrice()
    }

    fun updateItemQuantity(cartItem: CartItem, newQuantity: Int) {
        val updatedCart = _cartItems.value!!.toMutableList()
        val index = updatedCart.indexOf(cartItem)
        if (index != -1) {
            updatedCart[index] = cartItem.copy(quantity = newQuantity)
            _cartItems.value = updatedCart
            calculateTotalPrice()
        }
    }

    private fun calculateTotalPrice() {
        val currentCart = _cartItems.value ?: emptyList()
        val total = currentCart.sumOf { it.product.price * it.quantity }
        _totalPrice.value = total
    }
}