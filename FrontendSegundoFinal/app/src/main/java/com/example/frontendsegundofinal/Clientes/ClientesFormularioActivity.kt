package com.example.frontendsegundofinal.Clientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontendsegundofinal.DatabaseApp
import com.example.frontendsegundofinal.R
import kotlinx.coroutines.launch

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
        var clientId = 0
        supportActionBar?.hide()
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
                lifecycleScope.launch {
                    val listRoom = DatabaseApp(context = applicationContext).room.databaseDAO().getAllClientes()
                    runOnUiThread {
                        clientesList.clear()
                        clientesList.addAll(listRoom)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
            intent.getStringExtra("flujo").toString() == "Borrar" -> {
                btnCliente.text = "Borrar Cliente"
                etEmail.visibility = View.GONE
                etNombreApellido.visibility = View.GONE
                rvClientes.visibility = View.GONE
                btnCliente.setOnClickListener {
                    lifecycleScope.launch {
                        DatabaseApp(context = applicationContext).room.databaseDAO().deleteClientes(etRuc.text.toString())
                        Toast.makeText(applicationContext, "Cliente Borrado", Toast.LENGTH_LONG).show()
                        finish()
                    }
                }
            }
            else -> {
                lifecycleScope.launch {
                    var total = 0
                    DatabaseApp(context = applicationContext).room.databaseDAO().getAllClientes().also {
                        if (it.isNotEmpty()) {
                           total = it.last().id
                        }
                    }
                    runOnUiThread {
                        clientId = total + 1
                    }
                }
                btnCliente.text = "Crear Cliente"
                rvClientes.visibility = View.GONE
                btnCliente.setOnClickListener {
                    lifecycleScope.launch {
                        var auxiliar = true
                        var message = ""

                        if (etEmail.text.isEmpty() || etRuc.text.isEmpty() || etNombreApellido.text.isEmpty()) {
                            auxiliar = false
                            message = "Hay campos vacios"
                        }

                        if (auxiliar) {
                            DatabaseApp(context = applicationContext).room.databaseDAO()
                                .insertClientes(
                                    ClientesEntity(
                                        id = clientId,
                                        nombre = etNombreApellido.text.toString(),
                                        ruc = etRuc.text.toString(),
                                        email = etEmail.text.toString()
                                    )
                                )
                            Toast.makeText(applicationContext, "Cliente Creado", Toast.LENGTH_LONG)
                                .show()
                            finish()
                        } else {
                            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}