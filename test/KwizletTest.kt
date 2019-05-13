package io.github.potatocurry.kwizlet

import io.github.potatocurry.kwizlet.api.Kwizlet
import org.junit.Test
import kotlin.test.*

class KwizletTest {
    @Test
    fun testSet() {
        val kwizlet = Kwizlet(System.getenv("QuizletClientID"))
        val set = kwizlet.getSet("389102373")
        val termMap = set.getTermMap()
        assertNotNull(termMap)
    }
}
