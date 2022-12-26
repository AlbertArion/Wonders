package com.example.wonders.vip.taste

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-13.
 */

internal class Foo constructor(var name: String = "", age: Int = 0) : Person() {

    init {
        println("constructor implementation of Foo: \n name = $name \n age = $age")
    }

    var nickname: String = ""
        get() = "Foo:" + field
        set(value) {
            println("execute setter for nickname in Foo")
            field = value
        }
}