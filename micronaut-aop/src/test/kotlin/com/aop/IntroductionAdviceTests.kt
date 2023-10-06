package com.aop

import com.aop.service.StubExample
import io.micronaut.context.ApplicationContext
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class IntroductionAdviceTests() {



    @Test
    fun `I can use my stub annotation`() {
        val applicationContext = ApplicationContext.run()

        val stubExample = applicationContext.getBean(StubExample::class.java)

        assertEquals(stubExample.hello, "hello")
        assertEquals(stubExample.five, 5)
        assertEquals(stubExample.goodbye, null)

        applicationContext.close()
    }

}
