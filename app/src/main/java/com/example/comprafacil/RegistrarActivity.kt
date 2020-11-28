package com.example.comprafacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class RegistrarActivity : AppCompatActivity() {

    private lateinit var txtName:EditText
    private lateinit var txtLastName:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtPassword:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var database:FirebaseFirestore
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        txtName=findViewById(R.id.txtName)
        txtLastName=findViewById(R.id.txtLastName)
        txtEmail=findViewById(R.id.txtEmail)
        txtPassword=findViewById(R.id.txtPassword)

        progressBar=findViewById(R.id.progressBar)

        database= FirebaseFirestore.getInstance()
        auth= FirebaseAuth.getInstance()


    }

    fun register(view: View) {
        createNewAccount()
    }

    private fun createNewAccount() {
        val name:String=txtName.text.toString()
        val lastName:String=txtLastName.text.toString()
        val email:String=txtEmail.text.toString()
        val password:String=txtPassword.text.toString()

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            progressBar.visibility=View.VISIBLE

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    task ->

                    if(task.isComplete) {
                        val user:FirebaseUser?=auth.currentUser
                        verifyEmail(user)

                        val userBD= hashMapOf(
                            "email" to email,
                            "nombre" to name,
                            "apellido" to lastName
                        )
                        database.collection("users")
                            .add(userBD)
                            .addOnSuccessListener { documentReference ->
                                println("Usuario registrado")
                            }
                            .addOnFailureListener { e ->
                                println("Error al agregar Usuario $e")
                            }
                        action()
                    }
                }

        }
    }

    private fun action() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun verifyEmail(user: FirebaseUser?) {
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this) {
                task ->

                if(task.isComplete){
                    Toast.makeText(this,"Email enviado", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this,"Error al enviar el email", Toast.LENGTH_LONG).show()
                }
            }
    }
}