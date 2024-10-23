package com.alfred.gasstationposition.core.di

import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import com.alfred.gasstationposition.ui.view.viewmodel.MainViewModel

val appModule = module {

    single(named("IODispatcher")) {
        Dispatchers.IO
    }

    viewModelOf(::MainViewModel)
}