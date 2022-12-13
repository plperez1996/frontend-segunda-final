package com.example.frontendsegundofinal.Registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.math.MathUtils
import androidx.lifecycle.lifecycleScope
import com.example.frontendsegundofinal.Database
import com.example.frontendsegundofinal.DatabaseApp
import com.example.frontendsegundofinal.R
import kotlinx.coroutines.launch

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
        supportActionBar?.hide()
        var ventasId = 0


        etCliente = findViewById(R.id.et_cliente)
        etProducto = findViewById(R.id.et_producto)
        etCantidad = findViewById(R.id.et_cantidad)
        etFecha = findViewById(R.id.et_fecha)
        btnGuardar = findViewById(R.id.btn_guardar)
        btnBack = findViewById(R.id.BtnBack)

        btnBack.setOnClickListener { finish() }

        lifecycleScope.launch{
            var total = 0
            DatabaseApp(context = applicationContext).room.databaseDAO().getAllventas().also {
                if(it.isNotEmpty()){
                    total = it.last().id
                }
            }
            runOnUiThread{
                ventasId = total + 1
            }
        }

        btnGuardar.setOnClickListener {
            lifecycleScope.launch{
                var auxiliar = false
                if(DatabaseApp(context = applicationContext).room.databaseDAO().getProductByCodigo(etProducto.text.toString()) == null){
                    auxiliar = false
                }else{
                    auxiliar = true
                }

                if(auxiliar){
                    lifecycleScope.launch{
                        DatabaseApp(context = applicationContext).room.databaseDAO().insertVenta(
                            RegistroVentasEntity(
                                id = ventasId,
                                fecha = etFecha.text.toString(),
                                nroFactura =  ventasId.toString(),
                                cliente = etCliente.text.toString(),
                                total = etCantidad.text.toString(),
                                producto = etProducto.text.toString()
                            )
                        )
                        Toast.makeText(applicationContext, "Se agrego registro de venta", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }else{
                    Toast.makeText(applicationContext, "Producto no existe", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}