package com.example.loginejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginejemplo.databinding.ActivityEspanolBinding

class ActivityEspanol : AppCompatActivity() {

    private lateinit var binding: ActivityEspanolBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEspanolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blocks = listOf(
            Block(R.drawable.schoolmaterials, "Tarea 10", "PROMEDIO:90"),
            Block(R.drawable.schoolmaterials, "Tarea 9", "PROMEDIO: 90"),
            Block(R.drawable.schoolmaterials, "Tarea 8", "PROMEDIO: 100"),
            Block(R.drawable.paperairplane, "Tarea 7", "PROMEDIO: 100"),
            Block(R.drawable.paperairplane, "Tarea 6", "PROMEDIO: 100"),
            Block(R.drawable.paperairplane, "Tarea 5", "PROMEDIO: 80"),
            Block(R.drawable.schoolmaterials, "Tarea 4", "PROMEDIO: 90"),
            Block(R.drawable.paperairplane, "Tarea 3", "PROMEDIO: 100"),
            Block(R.drawable.paperairplane, "Tarea 2", "PROMEDIO: 100"),
            Block(R.drawable.schoolmaterials, "Tarea 1", "PROMEDIO: 100")

        )

        val adapter = BlocksAdapter(blocks, object : BlocksAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
            }
        })

        binding.recyclerViewTareas.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTareas.adapter = adapter

        binding.msjEnviar.setOnClickListener{
            val intent = Intent(this,ActivityMensaje::class.java)
            startActivity(intent)
        }
    }
}
