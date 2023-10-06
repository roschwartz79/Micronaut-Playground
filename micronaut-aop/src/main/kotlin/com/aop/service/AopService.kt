package com.aop.service

import com.aop.annotation.NotBlankString
import com.aop.annotation.PrintClassName
import jakarta.inject.Singleton

@Singleton
open class AopService {

    @NotBlankString
    open fun concat(string1: String, string2: String) {
        println(string1 + string2)
    }

    @PrintClassName
    open fun whoAmI() {
        println("I'm Rob!")
    }

}