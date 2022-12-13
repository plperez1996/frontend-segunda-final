package com.example.frontendsegundofinal.Registro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.R

class ReportesAdapter (val ventas : List<RegistroVentasEntity>) : RecyclerView.Adapter<ReportesAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_ventas, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = ventas[position]
        holder.cliente.text = p.cliente ?: ""
        holder.fecha.text = p.fecha ?: ""
        holder.nroFactura.text = p.nroFactura ?: ""
        holder.totalVenta.text = p.total ?: ""
    }

    override fun getItemCount(): Int {
        return ventas.size
    }

    class ViewHolder(v: View):  RecyclerView.ViewHolder(v){
        var cliente: TextView
        var fecha: TextView
        var nroFactura: TextView
        var totalVenta: TextView

        init {
            cliente = v.findViewById(R.id.tvCliente)
            fecha = v.findViewById(R.id.tvFecha)
            nroFactura = v.findViewById(R.id.tvNroFactura)
            totalVenta = v.findViewById(R.id.tvTotalVenta)
        }
    }
}