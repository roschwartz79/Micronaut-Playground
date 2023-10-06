package com.aop

import com.aop.service.AopService
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@MicronautTest
class AroundAdviceTests(@Inject private val aopService: AopService) {

    @Test
    fun `I can use my not blank string annotation`() {
        val exception = assertThrows<IllegalArgumentException> {
            aopService.concat("Hi", "")
        }

        assertEquals(exception.message, "Param string2 is not allowed to be an empty String.")
    }

    @Test
    fun `My Introduction Advice method prints out what I want`() {
        aopService.whoAmI()
    }

}
