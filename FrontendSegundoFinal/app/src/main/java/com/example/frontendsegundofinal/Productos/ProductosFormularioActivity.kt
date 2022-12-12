package com.example.frontendsegundofinal.Productos

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageButton
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.DatabaseApp
import com.example.frontendsegundofinal.R
import kotlinx.coroutines.launch

class ProductosFormularioActivity : AppCompatActivity() {
    private lateinit var btBack: ImageButton
    private lateinit var etCodigo: EditText
    private lateinit var etNombre: EditText
    private lateinit var etPrecio: EditText
    private lateinit var etExistencia: EditText
    private lateinit var btnProducto: Button
    private lateinit var container: GridLayout
    private lateinit var  rvProductos : RecyclerView
    private lateinit var adapter : ProductosAdapter
    private val productosList = mutableListOf<ProductosEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos_formulario)
        val intent = intent

        etCodigo = findViewById(R.id.et_codigo)
        etNombre = findViewById(R.id.et_nombre)
        etPrecio = findViewById(R.id.et_precio_venta)
        etExistencia = findViewById(R.id.et_existencia)
        btnProducto = findViewById(R.id.btn_registrar_producto)
        container = findViewById(R.id.grid_container)
        rvProductos = findViewById(R.id.rvInfo)
        rvProductos.layoutManager = LinearLayoutManager(this)

        adapter = ProductosAdapter(productosList)
        rvProductos.adapter = adapter
        btBack = findViewById(R.id.BtnBack)

        btBack.setOnClickListener {
            finish()
        }

        when {
            intent.getStringExtra("flujo").toString() == "Ver" -> {
                container.visibility = View.GONE
                lifecycleScope.launch {
                    val listRoom = DatabaseApp(context = applicationContext).room.databaseDAO().getAllProductos()
                    Log.d("plp", listRoom.toString())
                    runOnUiThread {
                        Log.d("plp2", listRoom.toString())
                        productosList.clear()
                        productosList.addAll(listRoom)
                        adapter.notifyDataSetChanged()
                    }


                }
            }
            intent.getStringExtra("flujo").toString() == "Borrar" -> {
                btnProducto.text = "Borrar Producto"
                etNombre.visibility = View.GONE
                etExistencia.visibility = View.GONE
                etPrecio.visibility = View.GONE
                rvProductos.visibility = View.GONE
            }
            else -> {
                btnProducto.text = "Crear Producto"
                rvProductos.visibility = View.GONE
            }
        }
    }
}