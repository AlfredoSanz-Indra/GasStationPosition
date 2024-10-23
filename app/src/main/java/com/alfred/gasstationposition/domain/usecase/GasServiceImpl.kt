package com.alfred.gasstationposition.domain.usecase

import com.alfred.gasstationposition.core.log.Klog
import com.alfred.gasstationposition.data.repositoryapi.RestServiceGob
import com.alfred.gasstationposition.domain.model.SimpleResponse
import com.alfred.gasstationposition.domain.usecaseapi.GasService

/**
 * @author Alfredo Sanz
 * @time 2024
 */
class GasServiceImpl(restServiceGob: RestServiceGob): GasService {

    override suspend fun getGasInfoFromGob(): SimpleResponse {
        Klog.line("GasServiceImpl", "getGasInfoFromGob", "init")

        return SimpleResponse(true, 200, "OK", "")
    }
}