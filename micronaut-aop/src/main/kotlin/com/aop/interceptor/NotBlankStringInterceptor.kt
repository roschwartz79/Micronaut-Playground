package com.aop.interceptor

import com.aop.annotation.NotBlankString
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import jakarta.inject.Singleton

@Singleton
@InterceptorBean(NotBlankString::class)
class NotBlankStringInterceptor : MethodInterceptor<Any, Any> {

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        val emptyStringParam = context.parameters.entries.stream().filter {
            val argumentValue = it.value
            argumentValue.value.toString() == ""
        }.findFirst()
        return if (emptyStringParam.isPresent) {
            throw IllegalArgumentException("Param ${emptyStringParam.get().key} is not allowed to be an empty String.")
        } else {
            context.proceed()
        }
    }
}