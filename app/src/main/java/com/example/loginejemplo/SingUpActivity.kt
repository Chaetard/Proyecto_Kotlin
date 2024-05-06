package com.example.loginejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginejemplo.databinding.ActivitySingUpBinding
import com.google.firebase.auth.FirebaseAuth

class SingUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.singUpBtn.setOnClickListener {
            val intent = Intent(this,SingInActivity::class.java)


            val email = binding.teEmail.text.toString()
            val pass = binding.tePass.text.toString()
            val pass2 = binding.tePassSecondary.text.toString()




            if (email.isEmpty() or pass.isEmpty() or pass2.isEmpty()){
                Toast.makeText(this,"Verifica la entrada", Toast.LENGTH_SHORT).show()
            }else{
                if(pass2 == pass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }





            }


        }

        binding.textView3.setOnClickListener{
            val intent = Intent(this,SingInActivity::class.java)
            startActivity(intent)
        }



    }
}