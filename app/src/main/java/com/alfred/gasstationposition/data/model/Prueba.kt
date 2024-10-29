package com.alfred.gasstationposition.data.model

import kotlinx.serialization.Serializable


@Serializable
data class Prueba(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)
