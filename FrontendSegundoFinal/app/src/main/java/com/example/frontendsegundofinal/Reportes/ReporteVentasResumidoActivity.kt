package com.example.frontendsegundofinal.Reportes

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.DatabaseApp
import com.example.frontendsegundofinal.R
import com.example.frontendsegundofinal.Registro.RegistroVentasEntity
import com.example.frontendsegundofinal.Registro.ReportesAdapter
import kotlinx.coroutines.launch

class ReporteVentasResumidoActivity : AppCompatActivity() {
    private val ventasList = mutableListOf<RegistroVentasEntity>()
    private val ventasOriginalList = mutableListOf<RegistroVentasEntity>()
    private lateinit var adapter : ReportesAdapter
    private lateinit var rvVentas : RecyclerView
    private lateinit var btnBack : ImageButton
    private lateinit var rbFecha : RadioButton
    private lateinit var rbCliente : RadioButton
    private lateinit var svVentas : SearchView
    private lateinit var btnFiltrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporte_ventas_resumido)
        supportActionBar?.hide()
        btnBack = findViewById(R.id.BtnBack)
        rvVentas = findViewById(R.id.rv_resumido)
        rvVentas.layoutManager = LinearLayoutManager(this)
        adapter = ReportesAdapter(ventasList)
        svVentas = findViewById(R.id.svSearch)
        rbFecha = findViewById(R.id.rbFecha)
        rbCliente = findViewById(R.id.rbCliente)
        btnFiltrar = findViewById(R.id.btnFilter)
        rvVentas.adapter = adapter

        btnFiltrar.setOnClickListener {
            if (rbCliente.isChecked) {
                getAdmiminstracionPacientes("cliente", svVentas.query.toString())
            } else if (rbFecha.isChecked) {
                getAdmiminstracionPacientes("fecha", svVentas.query.toString())
            }
        }


        svVentas.setOnCloseListener {
            ventasList.clear()
            ventasList.addAll(ventasOriginalList)
            adapter.notifyDataSetChanged()
            false
        }

        lifecycleScope.launch{
            val listVentas = DatabaseApp(context = applicationContext).room.databaseDAO().getAllventas()
            runOnUiThread{
                ventasList.clear()
                ventasList.addAll(listVentas)
                ventasOriginalList.addAll(listVentas)
                adapter.notifyDataSetChanged()
            }
        }

        btnBack.setOnClickListener { finish() }
    }

    private fun getAdmiminstracionPacientes(opcion: String = "", cadena: String = "") {
        lifecycleScope.launch{
            if (opcion == "cliente") {
                val listVentas = DatabaseApp(context = applicationContext).room.databaseDAO().getVentasByCliente(cadena)
                runOnUiThread{
                    ventasList.clear()
                    if (cadena.isEmpty()) {
                        ventasList.addAll(ventasOriginalList)
                    } else {
                        ventasList.addAll(listVentas)
                    }
                    adapter.notifyDataSetChanged()
                }
            }else {
                val listVentas = DatabaseApp(context = applicationContext).room.databaseDAO().getVentasByFecha(cadena)
                runOnUiThread{
                    ventasList.clear()
                    if (cadena.isEmpty()) {
                        ventasList.addAll(ventasOriginalList)
                    } else {
                        ventasList.addAll(listVentas)
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}