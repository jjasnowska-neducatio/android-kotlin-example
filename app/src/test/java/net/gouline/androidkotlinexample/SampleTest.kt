package net.gouline.androidkotlinexample

import net.gouline.androidkotlinexample.test.TestRunner
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestRunner::class)
class SampleTest {

    @Test
    fun testPointlessness() {
        assertEquals("Sample meaningless test", true, true)
    }

}
