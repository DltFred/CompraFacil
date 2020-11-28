package com.example.comprafacil.sqlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DecimalFormat

@Entity(tableName = "tabla_producto")
class Producto(
    @PrimaryKey @ColumnInfo(name="codigo") val cod_prod: String,
    @ColumnInfo(name="nombre") val nom_prod: String,
    @ColumnInfo(name="descripcion") val desc_prod: String,
    @ColumnInfo(name="marca") val marc_prod: String,
    @ColumnInfo(name="contenido") val cont_prod: String,
    @ColumnInfo(name="precio") val prec_prod: Double,
    @ColumnInfo(name="stock") val stk_prod: Int
)