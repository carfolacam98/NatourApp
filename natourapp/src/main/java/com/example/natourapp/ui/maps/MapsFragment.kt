package com.example.natourapp.ui.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.natourapp.R
import com.example.natourapp.ui.detail.DetailFragmentArgs

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val args: DetailFragmentArgs by navArgs()
        val lugar = args.lugar

        val posiLugar = LatLng(lugar.latitud, lugar.longitud)  // Revisar cómo mandar el objeto
        googleMap.addMarker(
            MarkerOptions()
                .position(posiLugar)
                .title(lugar.nombre)
                .snippet("Calificación: " + lugar.caliicacion) // Se puede cambiar por la puntuación, pero depende del objeto
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posiLugar, 12F))

        /*

        val cascadaFinMundo = LatLng(1.1035694, -76.6246555)  // Revisar cómo mandar el objeto
        googleMap.addMarker(
            MarkerOptions()
                .position(cascadaFinMundo)
                .title("Cascada Fin del Mundo")
                .snippet("Mocoa") // Se puede cambiar por la puntuación, pero depende del objeto
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cascadaFinMundo, 12F))

         */
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}