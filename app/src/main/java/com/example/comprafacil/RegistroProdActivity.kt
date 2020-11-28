package com.example.comprafacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import com.google.firebase.firestore.FirebaseFirestore

class RegistroProdActivity : AppCompatActivity() {

    private lateinit var txtCodigo:EditText
    private lateinit var txtNombreProducto:EditText
    private lateinit var txtDescripcion:EditText
    private lateinit var txtMarca:EditText
    private lateinit var txtContenido:EditText
    private lateinit var txtPrecioProducto:EditText
    private lateinit var txtStock:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var db: FirebaseFirestore

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

        db= FirebaseFirestore.getInstance()
        println(db)
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

            val products = hashMapOf(
                "codigo" to codigo,
                "contenido" to contenido,
                "descripcion" to descripcion,
                "marca" to marca,
                "nombre" to nombre,
                "precio" to precio,
                "stock" to stock
            )
            db.collection("products")
                .add(products)
                .addOnSuccessListener { documentReference ->
                    println("Producto registrado")
                }
                .addOnFailureListener { e ->
                    println("Error al agregar producto $e")
                }
            action()

        }
    }

    private fun action() {
        startActivity(Intent(this,MainActivity::class.java))
    }
}