package com.aop.service

import com.aop.annotation.Stub

@Stub
interface StubExample {

    @get:Stub("hello")
    val hello: String

    @get:Stub("5")
    val five: Int

    val goodbye: String
}