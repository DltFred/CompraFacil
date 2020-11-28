package com.example.comprafacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistroProdActivity : AppCompatActivity() {

    private lateinit var txtCodigo:EditText
    private lateinit var txtNombreProducto:EditText
    private lateinit var txtDescripcion:EditText
    private lateinit var txtMarca:EditText
    private lateinit var txtContenido:EditText
    private lateinit var txtPrecioProducto:EditText
    private lateinit var txtStock:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_prod)

        txtCodigo=findViewById(R.id.txtCodigo)
        txtNombreProducto=findViewById(R.id.txtNombreProducto)
        txtDescripcion=findViewById(R.id.txtDescripcion)
        txtMarca=findViewById(R.id.txtMarca)
        txtContenido=findViewById(R.id.txtContenido)
        txtPrecioProducto=findViewById(R.id.txtPrecioProducto)
        txtStock=findViewById(R.id.txtStock)

        progressBar= findViewById(R.id.progressBar)

        database= FirebaseDatabase.getInstance()
        println(database)

        dbReference=database.reference.child("Products")

    }

    fun register(view:View) {
        createNewProduct()
    }

    private fun createNewProduct() {
        val codigo:String=txtCodigo.text.toString()
        val nombre:String=txtNombreProducto.text.toString()
        val descripcion:String=txtDescripcion.text.toString()
        val marca:String=txtMarca.text.toString()
        val contenido:String=txtContenido.text.toString()
        val precio:String=txtPrecioProducto.text.toString()
        val stock:String=txtStock.text.toString()

        if(!TextUtils.isEmpty(codigo) && !TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(descripcion) && !TextUtils.isEmpty(marca) && !TextUtils.isEmpty(contenido) && !TextUtils.isEmpty(precio) && !TextUtils.isEmpty(stock)) {
            progressBar.visibility=View.VISIBLE

            val products = null
            val userBD=dbReference.child(products?.category.toString())

            userBD.child("Codigo").setValue(codigo)
            userBD.child("Nombre").setValue(nombre)
            userBD.child("Descripcion").setValue(descripcion)
            userBD.child("Marca").setValue(marca)
            userBD.child("Contenido").setValue(contenido)
            userBD.child("Precio").setValue(precio)
            userBD.child("Stock").setValue(stock)
            action()

        }
    }

    private fun action() {
        startActivity(Intent(this,MainActivity::class.java))
    }
}