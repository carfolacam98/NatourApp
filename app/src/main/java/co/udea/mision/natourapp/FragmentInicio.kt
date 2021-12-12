package co.udea.mision.natourapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import co.udea.mision.natourapp.databinding.FragmentHomeBinding
import co.udea.mision.natourapp.databinding.FragmentInicioBinding


class FragmentInicio : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView2.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentInicio2_to_fragmentLugares)
        }

        binding.imageView3.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentInicio2_to_listLugarActivity)
        }

        binding.imageView4.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentInicio2_to_registerActivity)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}