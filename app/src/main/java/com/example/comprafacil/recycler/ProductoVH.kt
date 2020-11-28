package com.example.comprafacil.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comprafacil.R

class ProductoVH (view: View): RecyclerView.ViewHolder(view){

    val lblCodigo : TextView = view.findViewById(R.id.lblCodigoProducto)
    val lblNombre : TextView = view.findViewById(R.id.lblNombreProducto)
    val lblDescripcion : TextView = view.findViewById(R.id.lblDescripcionProducto)
    val lblMarca : TextView = view.findViewById(R.id.lblMarcaProducto)
    val lblContenido : TextView = view.findViewById(R.id.lblContenidoProducto)
    val lblPrecio : TextView = view.findViewById(R.id.lblPrecioProducto)
    val lblStock : TextView = view.findViewById(R.id.lblStockProducto)

}