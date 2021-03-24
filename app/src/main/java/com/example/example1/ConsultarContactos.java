package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarContactos extends AppCompatActivity {

    Button btnConsultar,btnRegresarMenu;
    EditText edtxtNombreConsu;
    TextView textViewDatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_contactos);

        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        edtxtNombreConsu = (EditText)findViewById(R.id.edtxtNombreConsu);
        textViewDatos = (TextView) findViewById(R.id.textViewDatos);
        btnRegresarMenu = (Button)findViewById(R.id.btnRegresarMenu);
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });
        btnRegresarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), agenda2.class);
                startActivity(intent);
            }
        });
    }

    public void consultar(){
        String nombreC = edtxtNombreConsu.getText().toString();

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String datos = preferences.getString(nombreC,"");
        if(datos.length() == 0){
            Toast.makeText(this, "no se encontro ese registro",Toast.LENGTH_LONG).show();
        }else {
            textViewDatos.setText("Telefono: "+ datos);
        }
    }
}