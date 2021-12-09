package com.example.natourapp.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.natourapp.model.Lugar
import com.example.natourapp.model.LugarItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel ()   {

    private var lugaresLoad : MutableLiveData <ArrayList<LugarItem>> = MutableLiveData<ArrayList<LugarItem>>()
    val lugaresLoaded : LiveData <ArrayList<LugarItem>> = lugaresLoad



    fun loadMochFromJson(listaLugaresString: InputStream?)  {
        val listaLugaresString = listaLugaresString?.bufferedReader().use {it!!.readText()}
        val gson = Gson()
        lugaresLoad.value= gson.fromJson(listaLugaresString, Lugar::class.java)

    }


}