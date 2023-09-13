package com.example.datachallenge

import java.io.Serializable

class Email (email:String):Serializable {
    var email: String = "";

    init {
        this.email=email;
    }
}