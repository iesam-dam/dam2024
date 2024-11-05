package edu.iesam.dam2024.app

import android.app.Application
import edu.iesam.dam2024.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class IesamApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@IesamApp)
            modules(AppModule().module)
        }
    }
}