package com.example.natourapp.data

import com.example.natourapp.model.Lugar
import retrofit2.http.GET

interface ApiService {
    @GET("carfolacam98/Natourapp/lugares")
    suspend fun getLugares(): Lugar
}