package com.example.giftkart.util

import android.util.Patterns

fun validateEmail(email: String): RegisterValidation{
    if(email.isEmpty())
    {
        return RegisterValidation.Failed("Email Cannot be empty")
    }
    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
    {
        return RegisterValidation.Failed("Wrong email format")
    }
    return RegisterValidation.Success
}

fun validatePassword(password: String): RegisterValidation{
    if(password.isEmpty())
    {
        return RegisterValidation.Failed("Password Cannot be empty")
    }
    if(password.length<6)
    {
        return RegisterValidation.Failed("Password should be 6 characters")
    }
    return RegisterValidation.Success
}