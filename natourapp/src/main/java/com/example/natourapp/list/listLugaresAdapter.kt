package com.example.natourapp.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


import com.example.natourapp.R
import com.example.natourapp.model.LugarItem
import com.squareup.picasso.Picasso


class ListLugaresAdapter(
    private val lugaresList :ArrayList<LugarItem>,
    private val onItemClicked: (LugarItem) -> Unit
    )
    :RecyclerView.Adapter<ListLugaresAdapter.ViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.card_lugar,parent,false)
    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugar=lugaresList[position]
        holder.itemView.setOnClickListener { onItemClicked(lugaresList[position]) }
        holder.bind(lugar)
    }

    override fun getItemCount(): Int {
    return lugaresList.size
    }

    fun appendItems(newItems: ArrayList<LugarItem>) {
        lugaresList.clear()
        lugaresList.addAll(newItems)
        notifyDataSetChanged()
    }


    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        private var nameTextView:TextView= itemview.findViewById(R.id.name_text_view)
        private var descripcionTextView:TextView= itemview.findViewById(R.id.description_textView)
        private var puntajeTextView:TextView= itemview.findViewById(R.id.puntaje_text_view)
        private var pictureView:ImageView= itemview.findViewById(R.id.pictureImageView)
        fun bind(lugar: LugarItem){

            nameTextView.text=lugar.nombre
            descripcionTextView.text=lugar.descripcion
            puntajeTextView.text= lugar.caliicacion.toString()
            Picasso.get().load(lugar.urlImage).into(pictureView)
        }
    }
}