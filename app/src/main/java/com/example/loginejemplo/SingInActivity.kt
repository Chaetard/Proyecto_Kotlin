package com.example.loginejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.loginejemplo.databinding.ActivitySingInBinding
import com.google.firebase.auth.FirebaseAuth



class SingInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        binding = ActivitySingInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.singInBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            val email = binding.teEmail.text.toString()
            val pass = binding.tePass.text.toString()
            if (email.isEmpty() or pass.isEmpty()){
                Toast.makeText(this,"Verifica la entrada",Toast.LENGTH_SHORT).show()
            }else{
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Datos Incorrectos",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.textView3.setOnClickListener{
            val intent = Intent(this,SingUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()

        firebaseAuth.signOut()
        

    }
}
