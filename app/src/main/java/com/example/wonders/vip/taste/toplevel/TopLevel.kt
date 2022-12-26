package com.example.wonders.vip.taste.toplevel

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-7.
 */

/**
 * Top-level function.
 */
fun topLevelFun(): String? {
    return "Congratulations! You have reached the top level fun of kotlin!"
}

/**
 * Top-level extension.
 */
fun String.hasValue(): Boolean {
    println(topLevelFun())
    return this != ""
}

infix fun Int.plus(x: Int): Int {
    return this + x
}

var <T> List<T>.lastIndex: Int
    get() = size - 1
    set(value) {
        lastIndex = value
    }