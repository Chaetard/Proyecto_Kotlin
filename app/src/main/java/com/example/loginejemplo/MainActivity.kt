package com.example.loginejemplo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginejemplo.databinding.ActivityMainBinding



data class Block(val imageResId: Int, val text: String, val text2: String  )

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blocks = listOf(
            Block(R.drawable.math, "Matematicas", "PROMEDIO: 91"),
            Block(R.drawable.espanol, "Español", "PROMEDIO: 82"),
            Block(R.drawable.atom, "Ciencias", "PROMEDIO: 70"),
            Block(R.drawable.brain, "Educacion Fisica", "PROMEDIO: 100"),
            Block(R.drawable.globe, "Geografia", "PROMEDIO: 88"),
            Block(R.drawable.teacher, "Etica", "PROMEDIO: 97"),
            Block(R.drawable.books, "Historia", "PROMEDIO: 71"),
            Block(R.drawable.pupil, "Tutorias", "PROMEDIO: 96")
        )

        val adapter = BlocksAdapter(blocks, object : BlocksAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val block = blocks[position]
                when (block.text) {
                    "Matematicas" -> {
                        val intent = Intent(this@MainActivity, ActivityMatematicas::class.java)
                        startActivity(intent)
                    }
                    "Español" -> {
                        val intent = Intent(this@MainActivity, ActivityEspanol::class.java)
                        startActivity(intent)
                    }
                    "Ciencias" -> {
                        val intent = Intent(this@MainActivity, ActivityCiencias::class.java)
                        startActivity(intent)
                    }
                    "Educacion Fisica" -> {
                        val intent = Intent(this@MainActivity, ActivityEducacionFisica::class.java)
                        startActivity(intent)
                    }
                    "Geografia" -> {
                        val intent = Intent(this@MainActivity, ActivityGeografia::class.java)
                        startActivity(intent)
                    }
                    "Etica" -> {
                        val intent = Intent(this@MainActivity, ActivityEtica::class.java)
                        startActivity(intent)
                    }
                    "Historia" -> {
                        val intent = Intent(this@MainActivity, ActivityHistoria::class.java)
                        startActivity(intent)
                    }
                    "Tutorias" -> {
                        val intent = Intent(this@MainActivity, ActivityTutorias::class.java)
                        startActivity(intent)
                    }

                }
            }
        })

        binding.recyclerViewTareas.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTareas.adapter = adapter
    }
}


/*

private lateinit var map: GoogleMap

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_map_view)
createFragment()
}

private fun createFragment() {
val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
mapFragment.getMapAsync(this)
}

override fun onMapReady(googleMap: GoogleMap) {
map = googleMap
val coordinates = LatLng(20.536842900647425, -103.9682817483684)
val marker = MarkerOptions().position(coordinates).title("CUVALLES")
map.addMarker(marker)
map.animateCamera(
    CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
    4000,
    null
)
}
}
*/





