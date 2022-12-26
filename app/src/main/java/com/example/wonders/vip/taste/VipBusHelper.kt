package com.example.wonders.vip.taste

import android.content.Context
import com.example.wonders.vip.taste.article.writeArticle
import com.example.wonders.vip.taste.toplevel.hasValue
import com.example.wonders.vip.taste.toplevel.plus

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-5-25.
 */

open class VipBusHelper {

    internal var context = null
    private var page = null
    private var history: String = "history"
    private var map: MutableMap<String, Int> = mutableMapOf("me" to 12, "you" to 13, "him" to 14, "her" to 15)

    companion object Factory {

        fun create(): VipBusHelper = VipBusHelper()

        fun collect(vararg args: User) {
            for (item in args) {
                println(item)
            }
        }
    }

    fun haveFun(context: Context) {
        val busStr: String = ""
        busStr.hasValue()
        busStr.isEmpty()
        val user: User = User("", 1);
        println("Vip bus name = " + user.name + ", bus age = " + user.age)
    }

    fun haveMoreFun(context: Context) {
        val busGroup = listOf<User>(User("global"), User(name = "china", age = 1), User("USA", age = 2), User("UK", 3))
        val oldest = busGroup.maxBy { it.age }
        println("The oldest is: $oldest")
        println("The top-level x = ${haveTopFun()}")
    }

    fun makeMapHaveFun(): Map<String, Int> {
        for ((k, v) in map) {
            if (v < 14) println("map element, k = $k")
        }
        return map.filter({ m -> m.value < 15 })
    }

    fun maxInt(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    private fun haveNoFun(str: String): Int? {
        var value: Int? = null
        try {
            value = str.toInt()
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return value
    }

    private fun haveTopFun(): Int {
        return x
    }

    private fun secret() = history.length

    private fun fooFun() {
        val foo = Foo()
        foo.nickname = "outer settled"
    }

    private fun sum(x: Int = 0, y: Int): Int {
        return x + y
    }

    private fun blockFun(): Boolean {
        /* Do sth.*/
        return true
    }

    private fun higherOrderPlus(a: Int, b: Int, f: (x: Int, y: Int) -> Int): Int {
        return f(a, b)
    }

    private fun rangeCtrlFun(x: Any) {
        for (i in 10 downTo 1 step 2) {
            println("Int value: $i")
        }
        when (x) {
            -1, 0 -> println("x is -1 or 0")
            in 1..10 -> println("x is in the range[1..10]")
            sum(1, 1) -> println("1 + 1 = ?")
            else -> println("otherwise")
        }
    }

    fun deconstruct() {
        var (name, age) = User("Albert", 18)
    }

    fun printMe(context: Context) {

        /**
         * Static fun usage.
         */
        VipBusHelper.collect(User(name = "1", age = 12))

        /**
         * Member fun usage.
         */
        haveFun(context)
        haveMoreFun(context)

        /**
         * Extension usage.
         */
        val variable = "variable"
        variable.hasValue()

        /**
         * Infix usage.
         */
        println("Top-level infix fun usage: 1 plus 2 = ${1 plus 2}")

        /**
         * Higher-order funs & lambdas
         */

        createMan()

        val lambdaResult = higherOrderPlus(1, 2, { a, b -> a + b })
        val funRefResult = higherOrderPlus(1, 2, Int::plus)
        println("The lambda sum of 1 and 2 is: $lambdaResult")
        println("The fun ref sum of 1 and 2 is: $funRefResult")
        println("The filtered map is: ${makeMapHaveFun()}")

        writeArticle()
    }

}

// Top-level variables
val PI = 3.14
var x = Int.MIN_VALUE

fun main(args: Array<String>) {
    VipBusHelper().deconstruct()
}