package com.example.ioasys
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class MyApplication : MultiDexApplication(){
    val BASE_URL = "https://empresas.ioasys.com.br"

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        confFonts()
    }

    private fun confFonts() {
        val calligraphyConfig = CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/Roboto-Regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build()
        ViewPump.init(
            ViewPump.builder()
            .addInterceptor(CalligraphyInterceptor(calligraphyConfig))
            .build())
    }
}