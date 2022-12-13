package com.example.frontendsegundofinal.Reportes

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.DatabaseApp
import com.example.frontendsegundofinal.R
import com.example.frontendsegundofinal.Registro.RegistroVentasEntity
import com.example.frontendsegundofinal.Registro.ReporteDetalladoAdapter
import com.example.frontendsegundofinal.Registro.ReportesAdapter
import kotlinx.coroutines.launch

class ReporteVentasDetalladoActivity : AppCompatActivity() {

    private val ventasList = mutableListOf<RegistroVentasEntity>()
    private lateinit var adapter : ReporteDetalladoAdapter
    private lateinit var rvVentas : RecyclerView
    private lateinit var btnBack : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporte_ventas_detallado)

        btnBack = findViewById(R.id.BtnBack)
        rvVentas = findViewById(R.id.rv_detallado)
        rvVentas.layoutManager = LinearLayoutManager(this)
        adapter = ReporteDetalladoAdapter(ventasList)
        rvVentas.adapter = adapter
        lifecycleScope.launch{
            val listVentas = DatabaseApp(context = applicationContext).room.databaseDAO().getAllventas()
            runOnUiThread{
                ventasList.clear()
                ventasList.addAll(listVentas)
                adapter.notifyDataSetChanged()
            }
        }

        btnBack.setOnClickListener { finish() }
    }
}