package com.example.frontendsegundofinal.Reportes

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.SearchView

import android.widget.Toast
import android.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.DatabaseApp
import com.example.frontendsegundofinal.R
import com.example.frontendsegundofinal.Registro.RegistroVentasEntity
import com.example.frontendsegundofinal.Registro.ReporteDetalladoAdapter
import com.example.frontendsegundofinal.Registro.ReportesAdapter
import kotlinx.coroutines.launch
import java.util.Locale.filter

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.search_menu, menu)

        val searchItem: MenuItem = menu!!.findItem(R.id.actionSearch)

        val searchView: SearchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String): Boolean {
                filter(p0)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun filter(text: String){
        val filteredlist: ArrayList<RegistroVentasEntity> = ArrayList()
        for(item in ventasList){
            if(item.producto.contains(text) || item.fecha.contains(text)){
                filteredlist.add(item)
            }
        }
        if(filteredlist.isEmpty()){
            Toast.makeText(applicationContext, "No se encontraron datos", Toast.LENGTH_SHORT).show()
        }else{
            adapter.filterList(filteredlist)
        }
    }
}