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

public class registrarContactos extends AppCompatActivity {

   EditText edtxtNombreC,edtxtTelefonoC;
   Button btnRegistrarContacto,btnRegresarMenu;
   TextView textViewDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_contactos);
        edtxtNombreC = (EditText)findViewById(R.id.edtxtNombreC);
        edtxtTelefonoC = (EditText)findViewById(R.id.edtxtTelefonoC);

        textViewDatos = (TextView)findViewById(R.id.textViewDatos);
        btnRegistrarContacto = (Button)findViewById(R.id.btnRegistrarContacto);
        btnRegresarMenu = (Button)findViewById(R.id.btnRegresarMenu);



        btnRegresarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), agenda2.class);
                startActivity(intent);
            }
        });
        btnRegistrarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( edtxtNombreC.length()<=0 || edtxtTelefonoC.length()<=0 ){
                    Toast.makeText(v.getContext(), "porfavor llenar todos los campos",Toast.LENGTH_LONG).show();
                }else{
                    registrar();
                }

            }
        });



    }

    public void registrar(){
        SharedPreferences preferences1 = getSharedPreferences("datos",Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = preferences1.edit();
        editor.putString( edtxtNombreC.getText().toString(), edtxtTelefonoC.getText().toString() );
        editor.commit();
        Toast.makeText(this, "Se ha guardado de manera correcta",Toast.LENGTH_LONG).show();
    }
    public void consultar(){
        String nombreC = edtxtNombreC.getText().toString();

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String datos = preferences.getString(nombreC,"");
        if(datos.length() == 0){
            Toast.makeText(this, "no se encontro ese registro",Toast.LENGTH_LONG).show();
        }else {
            textViewDatos.setText(datos);
        }
    }
}