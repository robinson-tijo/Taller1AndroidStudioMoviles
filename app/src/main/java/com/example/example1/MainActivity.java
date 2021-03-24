package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtxtName , edtxtContrasena;
    Button btnLogin;
    String name,con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxtName = (EditText) findViewById(R.id.edtxtName);
        edtxtContrasena = (EditText) findViewById(R.id.edtxtContrasena);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edtxtName.getText().toString();
                con  = edtxtContrasena.getText().toString();
                if( name.length()<=0 || con.length()<=0  ){
                    Toast.makeText(v.getContext(), "porfavor llenar todos los campos",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent (v.getContext(), agenda2.class);
                    intent.putExtra("nombre",name);
                    startActivity(intent);
                }

            }
        });
    }

}