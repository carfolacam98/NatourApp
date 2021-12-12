package co.udea.mision.natourapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import co.udea.mision.natourapp.databinding.FragmentHomeBinding



class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonSiguienteHome.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentLugares_to_registerActivity3)
        }

        binding.botonLugaresHome.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentLugares_to_listLugarActivity3)
        }

        binding.botonInicioHome.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentLugares_to_fragmentInicio2)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}