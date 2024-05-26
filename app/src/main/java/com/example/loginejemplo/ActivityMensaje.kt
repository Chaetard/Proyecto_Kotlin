package com.example.loginejemplo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityMensaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje)

        val btnEnviarMensaje = findViewById<Button>(R.id.btnEnviarMensaje)
        val editTextMensaje = findViewById<EditText>(R.id.editTextMensaje)

        btnEnviarMensaje.setOnClickListener {
            val mensaje = editTextMensaje.text.toString()
            enviarMensaje(mensaje)
            editTextMensaje.text.clear()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun enviarMensaje(mensaje: String) {
        Toast.makeText(this, "Mensaje enviado: $mensaje", Toast.LENGTH_SHORT).show()
    }
}
