package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edCorreoLg, edContrasenaLg;
    Button btnIngresar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edCorreoLg = findViewById (R.id.edCorreoLg);
        edContrasenaLg = findViewById (R.id.edContrasenaLg);
        btnIngresar = findViewById (R.id.btnIngresar);
        btnRegistrar = findViewById (R.id.btnRegistro);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCickIngresar();

            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRegistrar();
            }
        });

    }
    private void onCickIngresar(){
        String correo = edCorreoLg.getText().toString();
        String contrasena = edContrasenaLg.getText().toString();
        if(!correo.isEmpty()){
            if(!contrasena.isEmpty()){
                if (correo.equals("mrobayoc@unisangil.edu.co")&& contrasena.equals("Laura")){
                Intent intent = new Intent (MainActivity.this,BienvenidoActivity.class);
                intent.putExtra("correo", correo);
                startActivity(intent);
                }else {
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();

                }

            }else{
               edContrasenaLg.setError("campo requrido");
            }
        }else{
            edCorreoLg.setError("campo requerido");
        }



    }
    private void onClickRegistrar(){
        Intent intent = new Intent (MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }

}