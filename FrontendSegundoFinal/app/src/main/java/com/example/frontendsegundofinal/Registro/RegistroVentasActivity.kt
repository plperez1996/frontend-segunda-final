package com.example.frontendsegundofinal.Registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.frontendsegundofinal.R

class RegistroVentasActivity : AppCompatActivity() {
    private lateinit var etCliente: EditText
    private lateinit var etProducto: EditText
    private lateinit var etCantidad: EditText
    private lateinit var etFecha: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_ventas)



        etCliente = findViewById(R.id.et_cliente)
        etProducto = findViewById(R.id.et_producto)
        etCantidad = findViewById(R.id.et_cantidad)
        etFecha = findViewById(R.id.et_fecha)
        btnGuardar = findViewById(R.id.btn_guardar)
        btnBack = findViewById(R.id.BtnBack)

        btnBack.setOnClickListener { finish() }




    }
}