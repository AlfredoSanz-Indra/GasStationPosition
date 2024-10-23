package com.alfred.gasstationposition.core.resource

import android.content.Context
import java.util.Properties

/**
 * @author Alfredo Sanz
 * @time 2024
 */
object TheResources {

    private lateinit var appProp: Properties

    fun getAppProp(baseContext: Context): Properties {
        if (!this::appProp.isInitialized) {
            appProp = readResources("app.properties", baseContext)
        }
        return appProp
    }
}