package com.example.wonders.vip.trip

import com.example.wonders.vip.trip.conveynace.TripTool
import com.example.wonders.vip.trip.conveynace.TripType
import java.util.*

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-22.
 */

fun tripPlan(dest: String, budget: Int = 5000): String {

    val schedule: Schedule = Schedule(dest = dest, budget = budget)

    val byAir = TripTool.create(schedule, TripType.ByAir)
    val byTrain = TripTool.create(schedule, TripType.ByTrain)
    val selfDriving = TripTool.create(schedule, TripType.SelfDriving)

    val comparator = Comparator<TripTool>(
            { t1: TripTool, t2: TripTool -> t1.getPrice() - t2.getPrice() })

    val sortedSet = sortedSetOf(comparator, byAir, byTrain, selfDriving)

    return sortedSet.printMe()
}

fun <T> SortedSet<T>.printMe(): String {
    val sb = StringBuilder()
    for (tool in this) {
        sb.append(tool.toString() + "\n")
    }
    return sb.toString()
}