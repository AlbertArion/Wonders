package com.example.wonders.vip.trip

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-22.
 */

class Schedule(val origin: String = "Beijing", val dest: String, var budget: Int = 1000) {

    var duration: Int = 1

    fun haveEnoughBudget(price: Int): Boolean = budget >= price

    fun getRoute(): String = StringBuilder().append(origin).append("-").append(dest).toString()

    override fun toString(): String {
        return "$origin-$dest \n budget: $budget"
    }
}