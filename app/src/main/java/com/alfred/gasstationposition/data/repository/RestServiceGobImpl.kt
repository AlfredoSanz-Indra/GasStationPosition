package com.alfred.gasstationposition.data.repository

import com.alfred.gasstationposition.core.log.Klog
import com.alfred.gasstationposition.data.model.SimpleDataResponse
import com.alfred.gasstationposition.data.repositoryapi.RestServiceGob
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author Alfredo Sanz
 * @time 2024
 */
class RestServiceGobImpl(private val ioDispatcher: CoroutineDispatcher): RestServiceGob {

    override suspend fun getPreciosCarburantesTerrestre(): SimpleDataResponse {
        Klog.line("RestServiceGobImpl", "getPreciosCarburantesTerrestre", "init")

        return SimpleDataResponse(true, 200, "OK")
    }
}