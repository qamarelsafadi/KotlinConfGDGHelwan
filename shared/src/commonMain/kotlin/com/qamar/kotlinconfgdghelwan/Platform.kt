package com.qamar.kotlinconfgdghelwan

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform