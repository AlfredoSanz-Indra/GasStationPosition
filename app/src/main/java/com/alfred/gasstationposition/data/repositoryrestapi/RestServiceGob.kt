package com.alfred.gasstationposition.data.repositoryrestapi

import com.alfred.gasstationposition.data.model.SimpleDataResponse

/**
 * @author Alfredo Sanz
 * @time 2024
 */
interface RestServiceGob {

    suspend fun getPreciosCarburantesTerrestre(): SimpleDataResponse

}