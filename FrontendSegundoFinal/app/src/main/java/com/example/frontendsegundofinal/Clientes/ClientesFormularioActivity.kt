package com.example.frontendsegundofinal.Clientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.R

class ClientesFormularioActivity : AppCompatActivity() {
    private lateinit var btBack: ImageButton
    private lateinit var etNombreApellido: EditText
    private lateinit var etRuc: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnCliente: Button
    private lateinit var container: GridLayout
    private lateinit var  rvClientes : RecyclerView
    private lateinit var adapter : ClientesAdapter
    private val clientesList = mutableListOf<ClientesEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes_formulario)
        val intent = intent
        etNombreApellido = findViewById(R.id.et_nombre_apellido)
        etRuc = findViewById(R.id.et_ruc)
        etEmail = findViewById(R.id.et_email)
        btnCliente = findViewById(R.id.btn_registrar_cliente)
        btBack = findViewById(R.id.BtnBack)
        container = findViewById(R.id.grid_container)
        rvClientes = findViewById(R.id.rvInfo)
        rvClientes.layoutManager = LinearLayoutManager(this)

        adapter = ClientesAdapter(clientesList)
        rvClientes.adapter = adapter
        btBack.setOnClickListener {
            finish()
        }

        when {
            intent.getStringExtra("flujo").toString() == "Ver" -> {
                container.visibility = View.GONE
            }
            intent.getStringExtra("flujo").toString() == "Borrar" -> {
                btnCliente.text = "Borrar Cliente"
                etEmail.visibility = View.GONE
                etNombreApellido.visibility = View.GONE
                rvClientes.visibility = View.GONE
            }
            else -> {
                btnCliente.text = "Crear Cliente"
                rvClientes.visibility = View.GONE
            }
        }
    }
}