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
            Klog.line("GasServiceImpl", "getGasInfoFromGob", "resp.prueba -> ${resp.prueba}")
            Klog.line("GasServiceImpl", "getGasInfoFromGob", "resp.estaciones.Nota -> ${resp.estaciones?.Nota}")
            Klog.line("GasServiceImpl", "getGasInfoFromGob", "resp.estaciones.ResultadoConsulta -> ${resp.estaciones?.ResultadoConsulta}")
            Klog.line("GasServiceImpl", "getGasInfoFromGob", "resp.estaciones.Fecha -> ${resp.estaciones?.Fecha}")
            Klog.line("GasServiceImpl", "getGasInfoFromGob", "resp.estaciones.ListaEESSPrecio.size -> ${resp.estaciones?.ListaEESSPrecio?.size}")
            result = SimpleResponse(true, resp.code, resp.message, "")
            result.dat = resp.estaciones?.Fecha
        }
        catch(e: Exception) {
            Klog.line("GasServiceImpl", "getGasInfoFromGob", "Error -> ${e.message}")
            result = SimpleResponse(false, 500, e.toString(), "")
        }

        return result
    }
}