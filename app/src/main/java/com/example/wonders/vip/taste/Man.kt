package com.example.wonders.vip.taste

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-13.
 */

open class Man : Person() {
    companion object Parent {
        fun create(): Person = Person()
    }
}

// Top-level funs
fun createMan() = Man.create()