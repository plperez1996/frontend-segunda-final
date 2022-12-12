package com.example.frontendsegundofinal.Clientes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.frontendsegundofinal.Productos.AdministracionProductosActivity
import com.example.frontendsegundofinal.R
import com.example.frontendsegundofinal.Registro.RegistroVentasActivity

class AdministracionClientesActivity : AppCompatActivity() {
    private lateinit var btBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administracion_clientes)

        val btnCrear = findViewById<Button>(R.id.btnCreate)
        val btnVer = findViewById<Button>(R.id.btnVer)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        btBack = findViewById(R.id.BtnBack)

        btnCrear.setOnClickListener {
            val intent = Intent(this, ClientesFormularioActivity::class.java)
            intent.putExtra("flujo", "Crear")
            startActivity(intent)
        }

        btnVer.setOnClickListener {
            val intent = Intent(this, ClientesFormularioActivity::class.java)
            intent.putExtra("flujo", "Ver")
            startActivity(intent)
        }

        btnBorrar.setOnClickListener {
            val intent = Intent(this, ClientesFormularioActivity::class.java)
            intent.putExtra("flujo", "Borrar")
            startActivity(intent)
        }

        btBack.setOnClickListener {
            finish()
        }
    }
}