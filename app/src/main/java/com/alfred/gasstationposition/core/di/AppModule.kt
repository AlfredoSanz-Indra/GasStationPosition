package com.alfred.gasstationposition.core.di

import com.alfred.gasstationposition.data.repository.RestServiceGobImpl
import com.alfred.gasstationposition.data.repositoryapi.RestServiceGob
import com.alfred.gasstationposition.domain.usecase.GasServiceImpl
import com.alfred.gasstationposition.domain.usecaseapi.GasService
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import com.alfred.gasstationposition.ui.view.viewmodel.MainViewModel

val appModule = module {

    single(named("IODispatcher")) {
        Dispatchers.IO
    }

    single<RestServiceGob> {
        RestServiceGobImpl(get(named("IODispatcher")))
    }

    factory<GasService> {
        GasServiceImpl(get())
    }

    viewModelOf(::MainViewModel)
}