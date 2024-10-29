package com.alfred.gasstationposition.data.model

import kotlinx.serialization.Serializable

/**
 * @author Alfredo Sanz
 * @time 2024
 */
@Serializable
data class ResultStations(
    val Fecha: String?,
    val Nota: String?,
    val ResultadoConsulta: String?,
    @Serializable() val ListaEESSPrecio: MutableList<EESSPrice> = mutableListOf()
)
