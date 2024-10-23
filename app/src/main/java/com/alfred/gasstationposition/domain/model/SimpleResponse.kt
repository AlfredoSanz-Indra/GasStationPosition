package com.alfred.gasstationposition.domain.model

/**
 * @author Alfredo Sanz
 * @time 2024
 */
data class SimpleResponse(val result: Boolean,
                          val code: Int,
                          val message: String,
                          val errorcode: String) {

    var dat: String? = null
    var datList: MutableList<String>? = null
}
