package co.udea.mision.natourapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugarItem(
    @SerializedName("caliicacion")
    val caliicacion: Double,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlImage")
    val urlImage: String
): Serializable