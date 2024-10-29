package com.alfred.gasstationposition.data.model

/**
 * @author Alfredo Sanz
 * @time 2024
 */
data class SimpleDataResponse(val result: Boolean,
                              val code: Int,
                              val message: String) {

    var dat: String? = null
    var datList: MutableList<String>? = null
    var prueba: Prueba? = null
    var estaciones: ResultStations? = null
}
