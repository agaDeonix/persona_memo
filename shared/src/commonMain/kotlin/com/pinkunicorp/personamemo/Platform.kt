package com.pinkunicorp.personamemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform