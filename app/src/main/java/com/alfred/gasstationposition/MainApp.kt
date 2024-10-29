package com.alfred.gasstationposition

import android.app.Application
import com.alfred.gasstationposition.core.di.appModule
import com.alfred.gasstationposition.core.log.Klog
import com.alfred.gasstationposition.core.log.KlogLevel
import com.alfred.gasstationposition.core.resource.TheResources
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

/**
 * @author Alfredo Sanz
 * @time 2024
 * @version 1.0.3
 */
class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        try {
            initApp()
        }
        catch(e: Exception){
            println("*** Error  initializating ${e.localizedMessage}")
            throw e
        }

        startKoin{
            androidLogger()
            androidContext(this@MainApp)
            modules(appModule)
        }
    }

    private fun initApp() {
        val logLevel: String = TheResources.getAppProp(baseContext)["log.level"] as String
        when(logLevel) {
            "DEBUG" -> Klog.updateLevel(KlogLevel.DEBUG)
            "PROD"  -> Klog.updateLevel(KlogLevel.PROD)
        }

        try {
            Klog.line("MainApp", "initApp", "LibraryMasters loaded")
        }
        catch(e: Exception) {
            Klog.line("MainApp", "initApp", " Exception localizedMessage: ${e.localizedMessage}")
            Klog.line("MainApp", "initApp", " Error loading LibraryMasters")
        }
    }
}