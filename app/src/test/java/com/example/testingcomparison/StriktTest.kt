package com.example.testingcomparison

import org.junit.Test
import strikt.api.Assertion
import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.doesNotContain
import strikt.assertions.hasSize
import strikt.assertions.isA

class StriktTest {

    private val animals = listOf("Rex", "Caramel", "Joe", "Anna")

    @Test
    fun striktList() {
        expectThat(animals)
            .isA<List<String>>()
            .contains("Rex")
            .doesNotContain("Snow")
            .hasAPalindrome()
            .hasSize(3)
    }

    @Test
    fun striktSucceeds(){
        expectThat(animals)
            .contains("Rex")
            .doesNotContain("Snow")
            .hasAPalindrome()
    }

    @Test
    fun striktSoftList() {
        expectThat(animals) {
            hasSize(3)
            contains("Rex")
            doesNotContain("Snow")
        }
    }

    private fun <T : Iterable<String>> Assertion.Builder<T>.hasAPalindrome(): Assertion.Builder<T> =
        assert("has a palindrome") {
            when (it.any { value -> value.reversed().equals(value, ignoreCase = true) }) {
                true -> pass()
                else -> fail()
            }
        }
}