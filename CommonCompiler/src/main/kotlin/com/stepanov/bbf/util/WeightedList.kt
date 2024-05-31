package com.stepanov.bbf.util

import java.io.File
import kotlin.random.Random

class WeightedList<T> {
    constructor(elements: List<Pair<T, Double>>) {
        elements.forEach { (element, weight) -> add(element, weight) }
    }

    constructor(elements: List<T>, value: Double) {
        elements.forEach { add(it, value) }
    }

    data class Element<T>(val element: T, val weight: Double)

    private val elements = mutableListOf<Element<T>>()
    private var accumulatedWeight = 0.0

    fun add(element: T, weight: Double) {
        accumulatedWeight += weight
        elements.add(Element(element, weight))
    }

    fun multiply(element: T, time: Double): Double {
        val i = findIndex(element) ?: throw Exception("The $element is not in the weighted list")
        val weight = elements[i].weight * time
        replace(element, weight)
        return weight
    }

    fun replace(element: T, weight: Double) {
        val i = findIndex(element)
        if (i != null) {
            accumulatedWeight -= elements[i].weight
            elements[i] = Element(element, weight)
        }
        else
            add(element, weight)
        accumulatedWeight += weight
    }

    private fun findIndex(element: T): Int? {
        var i = 0
        elements.map { item ->
            if (item.element == element)
                return i
            i += 1
        }
        return null
    }

    fun getRandom(): T? {
        val r = Random.nextDouble() * accumulatedWeight
        require(r in 0.0..accumulatedWeight)
        var weights = 0.0
        elements.forEach {
            weights += it.weight
            if (weights >= r) {
                return it.element
            }
        }
        return null
    }

    fun dump(filename: String) {
        File(filename).writeText("")
        elements.forEach {
            File(filename).appendText("${it.element}: ${it.weight}\n")
        }
    }

    fun at(i: Int): T? {
        if (i < 0 || i >= elements.size) {
            return null
        }
        return elements[i].element
    }

    fun size() = elements.size

    fun isEmpty() = elements.isEmpty()
}