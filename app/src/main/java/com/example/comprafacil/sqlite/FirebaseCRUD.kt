package com.example.comprafacil.sqlite

import com.google.firebase.firestore.FirebaseFirestore

class FirebaseCRUD {
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun listarProductos(): ArrayList<Producto> {
        var lista = ArrayList<Producto>()

        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    println("${document.id} => ${document.data}")
                    val producto: Producto = Producto(
                        cod_prod = document.data.toString(),
                        nom_prod = document.data.toString(),
                        marc_prod = document.data.toString(),
                        cont_prod = document.data.toString(),
                        prec_prod = 999.99,
                        desc_prod = document.data.toString(),
                        stk_prod = 999
                    )
                    lista.add(producto)
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents:  $exception")
            }
        return lista
    }

}