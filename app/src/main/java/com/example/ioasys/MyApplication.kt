package com.example.ioasys
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.example.ioasys.sections.home.fragments.list.ListViewModel
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : MultiDexApplication(){
    val BASE_URL = "https://empresas.ioasys.com.br"

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }

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

    private val appModule = module {
        viewModel { params -> ListViewModel(get(), view = params[0], listDataSource = params[1]) }
    }
}