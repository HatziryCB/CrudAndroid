package com.example.crudandroid2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.crudandroid2.utilidades.utilidades;

public class Registro extends AppCompatActivity {
private EditText nombreEditText, correoEditText, telefonoEditText;
private Button registrarButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registro);

    nombreEditText  = findViewById(R.id.nombreEditText);
    correoEditText    = findViewById(R.id.correoEditText);
    telefonoEditText     = findViewById(R.id.telefonoEditText);
    registrarButton = findViewById(R.id.registrarButton);

    registrarButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {  registrarCliente();  }
    });
}

    public void registrarCliente(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_stock", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(utilidades.CAMPO_NOMBRE, nombreEditText.getText().toString());
            values.put(utilidades.CAMPO_CORREO, correoEditText.getText().toString());
            values.put(utilidades.CAMPO_TELEFONO, Integer.parseInt(telefonoEditText.getText().toString()));

            long result = db.insert(utilidades.CLIENTE, null, values);

            if (result != -1) {
                Toast.makeText(this, "Registro realizado con éxito", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            } else {
                Toast.makeText(this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            Toast.makeText(this, "Error: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("DB_ERROR", "Error al registrar: ", e);
        } finally {
            db.close();
        }
    }
    private void limpiarCampos(){
        nombreEditText.setText("");
        correoEditText.setText("");
        telefonoEditText.setText("");
    }
}