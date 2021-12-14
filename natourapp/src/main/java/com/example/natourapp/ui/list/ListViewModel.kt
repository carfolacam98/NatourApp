package com.example.natourapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.natourapp.data.LugaresRepository
import com.example.natourapp.model.Lugar
import com.example.natourapp.model.LugarItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var lugaresLoad : MutableLiveData <ArrayList<LugarItem>> = MutableLiveData()
    val onLugaresLoaded: LiveData<ArrayList<LugarItem>> = lugaresLoad

    private val repository = LugaresRepository()

    fun getLugaresFromServer(){
        GlobalScope.launch (Dispatchers.IO){
            lugaresLoad.postValue(repository.getLugares())
        }

    }

    fun loadMockLugarFromJson(lugaresString: InputStream?) {
        val lugarString = lugaresString?.bufferedReader().use {it!!.readText()}
        val gson = Gson()
        lugaresLoad.value = gson.fromJson(lugarString, Lugar::class.java)
    }
}