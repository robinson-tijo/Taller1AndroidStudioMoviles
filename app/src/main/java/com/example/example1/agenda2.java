package com.example.example1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class agenda2 extends AppCompatActivity {

    TextView textViewBiem;
    Button btnRegresarLogin,btnRegistrarC,btnVentanaConsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda2);
        textViewBiem = (TextView)findViewById(R.id.textViewBiem);
        btnVentanaConsult = (Button)findViewById(R.id.btnVentanaConsult);
        btnRegresarLogin = (Button) findViewById(R.id.btnRegresarLogin);
        btnRegistrarC = (Button) findViewById(R.id.btnRegistrarC);
        String nombre = getIntent().getStringExtra("nombre");
        if(nombre == null){
            textViewBiem.setText("     Menu de contactos ");
        }else{
            textViewBiem.setText("  Bienvenido: " + nombre );
        }

        btnRegresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnRegistrarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), registrarContactos.class);
                startActivity(intent);
            }
        });
        btnVentanaConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ConsultarContactos.class);
                startActivity(intent);
            }
        });



    }
}