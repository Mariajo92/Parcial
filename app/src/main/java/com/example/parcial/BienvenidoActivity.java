package com.example.parcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BienvenidoActivity extends AppCompatActivity {
    ImageView Imagen;
    TextView saludo;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idItem = item.getItemId();
        if (idItem == R.id.item1){
            ClickCerrarSesion();

        }else if(idItem == R.id.item2){
            ClickModificar();


        }
        return super.onOptionsItemSelected(item);

    }




    private void ClickCerrarSesion(){
        Intent intent = new Intent (BienvenidoActivity.this,MainActivity.class);
        startActivity(intent);


    }
    private void ClickModificar(){
        Intent intent = new Intent (BienvenidoActivity.this,NosotrosActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        Imagen =findViewById(R.id.imagen);
        saludo = findViewById(R.id.textBienvenido);
        String B = saludo.getText().toString();
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/primer-proyecto-b27bf.appspot.com/o/descarga.png?alt=media&token=25c46eb9-55a2-4c48-a31e-31198e8874d2 ")
                .into(Imagen);
        Intent intent= getIntent();
        String bienvenido=intent.getStringExtra("correo");
        saludo.setText(B +" "+ bienvenido);



    }








}