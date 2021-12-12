package co.udea.mision.natourapp.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import co.udea.mision.natourapp.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        /*val lugar: LugarItem = intent.extras?.getSerializable("lugar") as LugarItem
        with(mainBinding){
            button.text=lugar.nombre
            descripcionView.text=lugar.descripcion
            Picasso.get().load(lugar.urlImage).into(imageView)
        }*/


    }
}