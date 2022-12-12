package com.example.frontendsegundofinal.Productos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.R

class ProductosAdapter (val productos : List<ProductosEntity>) : RecyclerView.Adapter<ProductosAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_productos_rv, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = productos[position]
        holder.nombre.text = p.nombre
        holder.codigo.text = p.codigo
        holder.precio.text = p.precio
        holder.existencia.text = p.existencia
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    class ViewHolder(v: View):  RecyclerView.ViewHolder(v){
        var nombre: TextView
        var codigo: TextView
        var precio: TextView
        var existencia: TextView

        init {
            nombre = v.findViewById(R.id.tvNombre)
            codigo = v.findViewById(R.id.tvCodigo)
            precio = v.findViewById(R.id.tvPrecio)
            existencia = v.findViewById(R.id.tvExistencia)
        }
    }
}