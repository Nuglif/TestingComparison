package com.example.testingcomparison

import org.assertj.core.api.Assertions
import org.assertj.core.api.ListAssert
import org.junit.Test

class AssertJTest {
    private val animals = listOf("Rex", "Caramel", "Joe", "Anna")

    @Test
    fun assertJ() {
        PalindromeAssert.assertThat(animals)
            .hasAPalindrome()
        Assertions.assertThat(animals)
            .hasOnlyElementsOfType(String::class.java) // Pretty weird IMO
            .contains("Rex")
            .doesNotContain("Snow")
            .hasSize(3)

    }

    private class PalindromeAssert(list: List<String>) :
        ListAssert<String>(list) {
        companion object {
            fun assertThat(actual: List<String>): PalindromeAssert {
                return PalindromeAssert(actual)
            }
        }

        fun hasAPalindrome(): PalindromeAssert {
            if (!actual.any { it.reversed().equals(it, ignoreCase = true) }) {
                failWithMessage("List doesn't contain a palindrome")
            }
            return this
        }
    }
}