package com.example.testingcomparison

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.should
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.Test

class KoTestTest {
    private val animals = listOf("Rex", "Caramel", "Joe", "Anna")

    @Test
    fun kotest() {
        animals should containPalyndrom()
        animals
            .shouldBeInstanceOf<List<String>>()
            .shouldContain("Rex") // Doesn't let me chain here
        animals.shouldNotContain("Snow") // Doesn't let me chain here
        animals.shouldHaveSize(3)
    }

    @Test
    fun kotestSoftList() {
        assertSoftly {
            animals.shouldHaveSize(2)
            animals
                .shouldBeInstanceOf<List<String>>()
                .shouldContain("Rex") // Doesn't let me chain here
            animals.shouldNotContain("Snow") // Doesn't let me chain here
            animals.shouldHaveSize(3)
        }
    }

    fun containPalyndrom() = object : Matcher<List<String>> {
        override fun test(value: List<String>): MatcherResult {
            return MatcherResult(
                value.any { it.reversed().equals(it, ignoreCase = true) },
                "List should contain palindrome",
                "List shouldn't contain palindrome"
            )
        }
    }
}