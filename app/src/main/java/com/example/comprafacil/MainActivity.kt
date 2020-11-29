package com.example.comprafacil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comprafacil.sqlite.FirebaseCRUD
import com.example.comprafacil.sqlite.Producto
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseCRUD
    private lateinit var lista: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lista = db.listarProductos()
    }

}