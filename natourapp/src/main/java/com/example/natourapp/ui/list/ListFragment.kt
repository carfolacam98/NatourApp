package com.example.natourapp.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.natourapp.databinding.FragmentListBinding
import com.example.natourapp.model.Lugar
import com.example.natourapp.model.LugarItem
import com.google.gson.Gson


class ListFragment : Fragment() {

 private lateinit var listBinding: FragmentListBinding
 private lateinit var listViewModel: ListViewModel
 private lateinit var listLugaresAdapter: ListLugaresAdapter
 private var listLugares :ArrayList<LugarItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding= FragmentListBinding.inflate(inflater,container,false)
        listViewModel= ViewModelProvider(this)[ListViewModel::class.java]
        return  listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //listViewModel.loadMockLugarFromJson(context?.assets?.open("lugaresTuristicos.json"))

        // https://my-json-server.typicode.com/
        listViewModel.getLugaresFromServer()

        listViewModel.onLugaresLoaded.observe(viewLifecycleOwner, { result ->
            onLugaresLoadedSubscribed(result)
        })

        listLugaresAdapter = ListLugaresAdapter(listLugares, onItemClicked = { onLugarClicked(it) })

        listBinding.lugaresRecycleView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listLugaresAdapter
            setHasFixedSize(false)
        }


    }

    private fun onLugaresLoadedSubscribed(result: ArrayList<LugarItem>?) {
        result?.let { listLugares ->
            listLugaresAdapter.appendItems(listLugares)


            /*this.listLugares = listLugares
            listLugaresAdapter.notifyDataSetChanged()*/
        }
    }

    private fun onLugarClicked(lugar: LugarItem) {
      findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar) )
      // findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment1() )
    }




    private fun loadMochFromJson(): ArrayList<LugarItem> {
        var listaLugaresString: String =context?.assets?.open("lugaresTuristicos.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(listaLugaresString, Lugar::class.java)
        return data
    }


}