package com.aop.annotation

import io.micronaut.aop.Introduction
import io.micronaut.context.annotation.Bean
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FILE
import kotlin.annotation.AnnotationTarget.FUNCTION
import kotlin.annotation.AnnotationTarget.PROPERTY_GETTER
import kotlin.annotation.AnnotationTarget.PROPERTY_SETTER
import kotlin.annotation.AnnotationTarget.ANNOTATION_CLASS

@Introduction
@Bean
@MustBeDocumented
@Target(CLASS, FILE, ANNOTATION_CLASS, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER)
annotation class Stub(val value: String = "unnamed")