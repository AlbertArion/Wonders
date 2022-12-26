package com.example.wonders.vip.taste.article

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-15.
 */

infix fun Any.like(a: Any) {
    print("\nI like $a")
}

infix fun Any.moreThan(a: Any) {
    print(" more than $a!\n")
}