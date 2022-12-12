package com.example.frontendsegundofinal.Productos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.frontendsegundofinal.Clientes.ClientesFormularioActivity
import com.example.frontendsegundofinal.R

class AdministracionProductosActivity : AppCompatActivity() {
    private lateinit var btBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administracion_productos)

        val btnCrear = findViewById<Button>(R.id.btnCreate)
        val btnVer = findViewById<Button>(R.id.btnVer)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)

        btnCrear.setOnClickListener {
            val intent = Intent(this, ProductosFormularioActivity::class.java)
            intent.putExtra("flujo", "Crear")
            startActivity(intent)
        }

        btnVer.setOnClickListener {
            val intent = Intent(this, ProductosFormularioActivity::class.java)
            intent.putExtra("flujo", "Ver")
            startActivity(intent)
        }

        btnBorrar.setOnClickListener {
            val intent = Intent(this, ProductosFormularioActivity::class.java)
            intent.putExtra("flujo", "Borrar")
            startActivity(intent)
        }

        btBack = findViewById(R.id.BtnBack)

        btBack.setOnClickListener {
            finish()
        }
    }
}