package com.alfred.gasstationposition.domain.usecase

import com.alfred.gasstationposition.core.log.Klog
import com.alfred.gasstationposition.data.repositoryrestapi.RestServiceGob
import com.alfred.gasstationposition.domain.model.SimpleResponse
import com.alfred.gasstationposition.domain.usecaseapi.GasService

/**
 * @author Alfredo Sanz
 * @time 2024
 */
class GasServiceImpl(private val restServiceGob: RestServiceGob): GasService {

    override suspend fun getGasInfoFromGob(): SimpleResponse {
        Klog.line("GasServiceImpl", "getGasInfoFromGob", "init")
        var result: SimpleResponse

        try {
            val resp =  restServiceGob.getPreciosCarburantesTerrestre()
            Klog.line("GasServiceImpl", "getGasInfoFromGob", "resp -> $resp")
            result = SimpleResponse(true, resp.code, resp.message, "")
            result.dat = resp.dat
        }
        catch(e: Exception) {
            Klog.line("GasServiceImpl", "getGasInfoFromGob", "Error -> ${e.message}")
            result = SimpleResponse(false, 500, e.toString(), "")
        }

        return result
    }
}