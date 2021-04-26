package com.example.ioasys
import android.app.Application
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import com.example.ioasys.R

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
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