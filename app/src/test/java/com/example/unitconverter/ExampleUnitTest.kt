package com.example.unitconverter

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test

class Converter {
    fun convertMilesToKilometers(miles: Double): Double {
        return miles * 1.60934  // Conversion factor for miles to kilometers
    }

    fun convertFahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5.0 / 9.0  // Conversion formula for Fahrenheit to Celsius
    }

    fun convertCelsiusToMeters(celsius: Double): Double {
        throw IllegalArgumentException("Conversion from Celsius to Meters is not valid.")
    }

}


class ConverterTest {
    private lateinit var converter: Converter

    @Before
    fun setup() {
        converter = Converter()  // Initialize your converter here
    }

    @Test
    fun testMilesToKilometers() {
        val miles = 10.0
        val expectedKilometers = 16.0934
        val result = converter.convertMilesToKilometers(miles)
        assertEquals(expectedKilometers, result, 0.001)
    }

    @Test
    fun testFahrenheitToCelsius() {
        val fahrenheit = 32.0
        val expectedCelsius = 0.0
        val result = converter.convertFahrenheitToCelsius(fahrenheit)
        assertEquals(expectedCelsius, result, 0.001)
    }

    @Test
    fun testInvalidConversion() {
        try {
            converter.convertCelsiusToMeters(100.0)  // Ensure this method exists and is designed to throw IllegalArgumentException
            fail("Expected an IllegalArgumentException")
        } catch (e: IllegalArgumentException) {
            // Expected exception
        }
    }
}


