package com.example.unittestingexample

object RegistrationUtil  {

    fun checkValidity(name : String,password:String) : Boolean{
        if(name.isEmpty() || password.isEmpty()){
            return false
        }
        return true
    }


}