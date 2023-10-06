package com.aop.interceptor

import com.aop.annotation.PrintClassName
import com.aop.annotation.Stub
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import jakarta.inject.Singleton

@Singleton
@InterceptorBean(Stub::class)
class StubMethodInterceptor: MethodInterceptor<Any, Any> {

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        return context.getValue<Any>(
            Stub::class.java,
            context.returnType.type
            ).orElse(null)
    }
}