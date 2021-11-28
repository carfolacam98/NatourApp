package com.example.natourapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.natourapp.R
import com.example.natourapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

  private lateinit var  detailBinding: FragmentDetailBinding
  private val args:DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding= FragmentDetailBinding.inflate(inflater,container,false)
        return  detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val lugar = args.lugar


        with(detailBinding){

            descripcionView.text=lugar.descripcion

        }

        }
    }

