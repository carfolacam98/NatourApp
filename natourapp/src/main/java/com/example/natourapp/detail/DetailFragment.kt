package com.example.natourapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.natourapp.R
import com.example.natourapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

  //private lateinit var  detailBinding: FragmentDetailBinding
  private val args:DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
        //detailBinding= FragmentDetailBinding.inflate(inflater,container,false)
        //return  detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView2.setOnClickListener {

            findNavController().navigate(R.id.action_detailFragment_to_settingsFragment1)
        }

        binding.imageView3.setOnClickListener {

            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }

         val lugar = args.lugar


        with(binding){


            titledetail.text=lugar.nombre
            descripcionView.text=lugar.descripcion
            com.squareup.picasso.Picasso.get().load(lugar.urlImage).into(imageView)


        }

        }
    }

