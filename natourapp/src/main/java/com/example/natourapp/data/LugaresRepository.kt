package com.example.natourapp.data

class LugaresRepository {
    suspend fun getLugares() = ApiFactory.retrofit.getLugares()
}