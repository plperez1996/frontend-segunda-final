package com.example.frontendsegundofinal.Clientes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.R

class ClientesAdapter (val clientes : List<ClientesEntity>) : RecyclerView.Adapter<ClientesAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_clientes_rv, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = clientes[position]
        holder.nombre.text = p.nombre
        holder.email.text = p.email
        holder.ruc.text = p.ruc
    }

    override fun getItemCount(): Int {
        return clientes.size
    }

    class ViewHolder(v: View):  RecyclerView.ViewHolder(v){
        var nombre: TextView
        var email: TextView
        var ruc: TextView

        init {
            nombre = v.findViewById(R.id.tvNombre)
            email = v.findViewById(R.id.tvEmail)
            ruc = v.findViewById(R.id.tvRuc)
        }
    }
}