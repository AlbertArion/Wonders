package com.example.wonders.vip.taste

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 *
 * Created by AlbertGao
 * on 18-6-5.
 */

data class User constructor(var name: String = "", var age: Int = 0) {

    init {
        println("Constructor init: User")
    }

    var nickName: String = ""

    constructor(ageP: Int, nameP: String, nickName: String) : this() {
        this.name = nameP
        this.age = ageP
        this.nickName = nickName
    }

    override fun toString(): String {
        return "User(name: $name, age: $age, nickName: $nickName)";
    }
}