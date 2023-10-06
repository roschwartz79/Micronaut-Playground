package com.aop.interceptor

import com.aop.annotation.PrintClassName
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import jakarta.inject.Singleton

@Singleton
@InterceptorBean(PrintClassName::class)
class PrintClassNameInterceptor: MethodInterceptor<Any, Any> {

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        println("Intercepted!")
        return context.proceed()
    }
}