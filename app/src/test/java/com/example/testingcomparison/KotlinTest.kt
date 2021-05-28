package com.example.testingcomparison

import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertTrue
import kotlin.test.asserter

class KotlinTest {

    private val animals = listOf("Rex", "Caramel", "Joe", "Anna")

    @Test
    fun kotlintest() {
        assertIs<List<String>>(animals)
        assertContains(animals, "Rex")
        assertFalse { animals.contains("Snow") }
        assertHasPalindrome(animals)
        assertTrue { animals.size == 3 }
    }

    private fun assertHasPalindrome(iterable: Iterable<String>) {
        asserter.assertTrue(
            {  "Expected the collection to contain a palindrome.\nCollection <$iterable>" },
            iterable.any { it.reversed().equals(it,ignoreCase = true) }
        )
    }
}