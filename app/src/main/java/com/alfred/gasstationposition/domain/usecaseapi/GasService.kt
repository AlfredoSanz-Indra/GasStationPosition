package com.alfred.gasstationposition.domain.usecaseapi

import com.alfred.gasstationposition.domain.model.SimpleResponse

/**
 * @author Alfredo Sanz
 * @time 2024
 */
interface GasService {

    suspend fun getGasInfoFromGob(): SimpleResponse
}