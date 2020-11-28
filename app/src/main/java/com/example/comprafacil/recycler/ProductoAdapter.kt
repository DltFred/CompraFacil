package com.example.comprafacil.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comprafacil.R
import com.example.comprafacil.sqlite.Producto

class ProductoAdapter (val miClick : (Producto) -> Unit): RecyclerView.Adapter<ProductoVH>()  {

    private var lista = ArrayList<Producto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoVH {
        return ProductoVH(LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false))
    }

    override fun onBindViewHolder(holder: ProductoVH, position: Int) {
        val product = lista[position]
        holder.lblCodigo.text = product.cod_prod
        holder.lblNombre.text = product.nom_prod
        holder.lblDescripcion.text = product.desc_prod
        holder.lblMarca.text = product.marc_prod
        holder.lblContenido.text = product.cont_prod
        holder.lblPrecio.text = product.prec_prod.toString()
        holder.lblStock.text = product.stk_prod.toString()
        holder.itemView.setOnClickListener{
            println("DIO CLICK: "+ product.cod_prod +  " - " + product.nom_prod)
            miClick(product)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun agregarProducto(nuevaLista: List<Producto>){
        lista.addAll(nuevaLista)
        notifyDataSetChanged()
    }
}