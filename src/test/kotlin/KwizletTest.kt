package io.github.potatocurry.kwizlet

import io.github.potatocurry.kwizlet.api.Kwizlet
import org.junit.Test
import java.net.URL
import kotlin.test.*

class KwizletTest {
    private val kwizlet = Kwizlet(System.getenv("QuizletClientID"))

    @Test
    fun testStandardSet() {
        val set = kwizlet.getSet("408405202")
        assertEquals(408405202, set.id)
        assertEquals("https://quizlet.com/408405202/kwizlet-test-set-flash-cards/", set.url)
        assertEquals("Kwizlet Test Set", set.title)
        assertEquals("DamianLall", set.author)
        assertEquals(3, set.termCount)
        assertEquals(1559151606, set.createdDate)
        assertEquals(1559151719, set.modifiedDate)
        assertEquals(1559151719, set.publishedDate)
        assertEquals(false, set.hasImages)
        assertEquals("public", set.visibility)
        assertEquals("only_me", set.editable)
        assertEquals(true, set.hasAccess)
        assertEquals(false, set.canEdit)
        assertEquals("This is a set used for testing the Kwizlet API wrapper.", set.description)
        assertEquals("en", set.termLanguage)
        assertEquals("en", set.definitionLanguage)
        assertEquals("Term 1", set.terms.first())
        assertEquals("Definition 3", set.definitions.last())

        for ((term, definition) in set.termPairs)
            println("$term: $definition")
    }

    // TODO: Add more sets
    @Test
    fun testOtherSets() {
        val set = kwizlet.getSet(URL("https://quizlet.com/389102373/ch33-flash-cards/"))
        assertEquals(389102373, set.id)
        assertEquals(30, set.termCount)
    }

    @Test
    fun testRandomSets() {
        // TODO: Test Search functionality
    }
}
