package com.example.wonders.vip.trip.conveynace.tools

import com.example.wonders.vip.trip.Schedule
import com.example.wonders.vip.trip.conveynace.TripTool
import com.example.wonders.vip.trip.conveynace.TripType

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-22.
 */

data class Airplane(val schedule: Schedule,
                    val type: TripType = TripType.ByAir)
    : TripTool() {

    override fun getPrice(): Int = priceMap.getOrDefault(schedule.getRoute(), Int.MAX_VALUE)

    val priceMap = mapOf<String, Int>(
            "Beijing-Hangzhou" to 2000,
            "Beijing-Tianjin" to 100,
            "Beijing-sanya" to 2800)

    override fun toString(): String {
        return "Trip: $schedule \n type: $type \n cost: ${getPrice()}\n"
    }
}