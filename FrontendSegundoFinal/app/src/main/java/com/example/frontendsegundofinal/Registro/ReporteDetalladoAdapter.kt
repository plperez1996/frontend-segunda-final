package com.example.frontendsegundofinal.Registro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.R
import org.w3c.dom.Text

class ReporteDetalladoAdapter (var ventas : List<RegistroVentasEntity>) : RecyclerView.Adapter<ReporteDetalladoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_ventas_detallado, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = ventas[position]
        holder.cliente.text = p.cliente ?: ""
        holder.fecha.text = p.fecha ?: ""
        holder.nroFactura.text = p.nroFactura ?: ""
        holder.cantidad.text = p.total ?: ""
        holder.producto.text = p.producto ?: ""
    }

    override fun getItemCount(): Int {
        return ventas.size
    }

    class ViewHolder(v: View):  RecyclerView.ViewHolder(v){
        var cliente: TextView
        var fecha: TextView
        var nroFactura: TextView
        var cantidad: TextView
        var producto: TextView

        init {
            cliente = v.findViewById(R.id.tvCliente)
            fecha = v.findViewById(R.id.tvFecha)
            nroFactura = v.findViewById(R.id.tvNroFactura)
            cantidad = v.findViewById(R.id.tvCantidad)
            producto = v.findViewById(R.id.tvProducto)
        }
    }

    fun filterList(filterlist: List<RegistroVentasEntity>){
        ventas = filterlist
        notifyDataSetChanged()
    }
}