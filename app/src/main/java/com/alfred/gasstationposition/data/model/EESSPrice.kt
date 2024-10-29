package com.alfred.gasstationposition.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Alfredo Sanz
 * @time 2024
 */
@Serializable
data class EESSPrice(
    @SerialName("C.P.") val CP: String?,
    @SerialName("Dirección") val Direccion: String?,
    val Horario: String?,
    val Latitud: String?,
    val Localidad: String?,
    @SerialName("Longitud (WGS84)") val Longitud: String?,
    val Margen: String?,
    val Municipio: String?,
    @SerialName("Precio Biodiesel") val Precio_Biodiesel: String?,
    @SerialName("Precio Bioetanol") val Precio_Bioetanol: String?,
    @SerialName("Precio Gas Natural Comprimido") val Precio_Gas_Natural_Comprimido: String?,
    @SerialName("Precio Gas Natural Licuado") val Precio_Gas_Natural_Licuado: String?,
    @SerialName("Precio Gases licuados del petróleo") val Precio_Gases_licuados_del_petroleo: String?,
    @SerialName("Precio Gasoleo A") val Precio_Gasoleo_A: String?,
    @SerialName("Precio Gasoleo B") val Precio_Gasoleo_B: String?,
    @SerialName("Precio Gasoleo Premium") val Precio_Gasoleo_Premium: String?,
    @SerialName("Precio Gasolina 95 E10") val Precio_Gasolina_95_E10: String?,
    @SerialName("Precio Gasolina 95 E5") val Precio_Gasolina_95_E5: String?,
    @SerialName("Precio Gasolina 95 E5 Premium") val Precio_Gasolina_95_E5_Premium: String?,
    @SerialName("Precio Gasolina 98 E10") val Precio_Gasolina_98_E10: String?,
    @SerialName("Precio Gasolina 98 E5") val Precio_Gasolina_98_E5: String?,
    @SerialName("Precio Hidrogeno") val Precio_Hidrogeno: String?,
    val Provincia: String?,
    @SerialName("Remisión") val Remision: String?,
    @SerialName("Rótulo") val Rotulo: String?,
    @SerialName("Tipo Venta") val Tipo_Venta: String?,
    @SerialName("% BioEtanol") val porcentaje_BioEtanol: String?,
    @SerialName("% Éster metílico") val porcentaje_Ester_metilico: String?,
    val IDEESS: String?,
    val IDMunicipio: String?,
    val IDProvincia: String?,
    val IDCCAA: String?,
)
