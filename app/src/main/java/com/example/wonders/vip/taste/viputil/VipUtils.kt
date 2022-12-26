package com.example.wonders.vip.taste.viputil

import com.example.wonders.vip.taste.toplevel.hasValue
import com.example.wonders.vip.taste.VipBusHelper

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-5.
 */

class VipUtils {
    fun extensionScope() {
        val str = "str"
        str.hasValue()
        VipBusHelper().context
    }
}