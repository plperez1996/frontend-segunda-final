package com.example.frontendsegundofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.frontendsegundofinal.Clientes.AdministracionClientesActivity
import com.example.frontendsegundofinal.Productos.AdministracionProductosActivity
import com.example.frontendsegundofinal.Registro.RegistroVentasActivity
import com.example.frontendsegundofinal.Reportes.ReporteVentasDetalladoActivity
import com.example.frontendsegundofinal.Reportes.ReporteVentasResumidoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btnAdmClient = findViewById<Button>(R.id.btnAdmClient)
        val btnAdmProd = findViewById<Button>(R.id.btnAdmProd)
        val btnRegVent = findViewById<Button>(R.id.btnRegVent)
        val btnRepVentDet = findViewById<Button>(R.id.btnRepVentDet)
        val btnRepVentRes = findViewById<Button>(R.id.btnRepVentRes)
        val btBack = findViewById<ImageButton>(R.id.BtnBack)

        btBack.visibility = View.GONE

        btnAdmClient.setOnClickListener {
            val intent = Intent(this, AdministracionClientesActivity::class.java)
            startActivity(intent)
        }

        btnAdmProd.setOnClickListener {
            val intent = Intent(this, AdministracionProductosActivity::class.java)
            startActivity(intent)
        }

        btnRegVent.setOnClickListener {
            val intent = Intent(this, RegistroVentasActivity::class.java)
            startActivity(intent)
        }

        btnRepVentRes.setOnClickListener {
            val intent = Intent(this, ReporteVentasResumidoActivity::class.java)
            startActivity(intent)
        }

        btnRepVentDet.setOnClickListener {
            val intent = Intent(this, ReporteVentasDetalladoActivity::class.java)
            startActivity(intent)
        }
    }

}