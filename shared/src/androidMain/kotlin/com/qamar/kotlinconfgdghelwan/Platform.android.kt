package com.qamar.kotlinconfgdghelwan

class AndroidPlatform : Platform {
    override val name: String = "KotlinConf ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()