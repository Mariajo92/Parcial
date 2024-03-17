package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    EditText edNombre, edCorreo, edDireccion, edTelefono, edFecha, edContrasena;
    Button btnEnviar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edNombre = findViewById(R.id.edNombreRg);
        edCorreo = findViewById(R.id.edcorreoReg);
        edDireccion = findViewById(R.id.eddireccionReg);
        edTelefono = findViewById(R.id.edtelefonoReg);
        edFecha = findViewById(R.id.edFechaReg);
        edContrasena = findViewById(R.id.editcontraseñaReg);

        edFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showDatePickerDialog();}
        });

    }
    public void clickEnviar (View view ){


        String nombre = edNombre.getText().toString();
        String correo = edCorreo.getText().toString();
        String direccion = edCorreo.getText().toString();
        String telefono = edTelefono.getText().toString();
        String fecha = edFecha.getText().toString();
        String contrasena = edContrasena.getText().toString();
        if(!nombre.isEmpty()) {
            if (!correo.isEmpty()){
                if(!direccion.isEmpty()){
                    if (!telefono.isEmpty()){
                        if (!fecha.isEmpty()){
                            if (!contrasena.isEmpty()){
                                AlertDialog.Builder alert = new AlertDialog.Builder(HomeActivity.this);
                                alert.setTitle("Confirmar").setMessage("¿sus datos son correctos?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(HomeActivity.this,BienvenidoActivity.class);
                                                intent.putExtra("correo",correo );
                                                startActivity(intent);

                                            }
                                        })
                                        .setNegativeButton("NO", null)
                                        .setCancelable(false)
                                        .show();

                            }else{
                                edContrasena.setError("Campo Requerido");

                            }

                        }else{
                            edFecha.setError("Campo Requerido");
                        }

                    }else {
                        edTelefono.setError("Campo Requerido");

                    }

                }else{
                    edDireccion.setError("Campo Requerido");
                }

            }else{
                edCorreo.setError("Campo Requerido");
            }
        }else{
            edNombre.setError("Campo Requerido");
        }



    }
    private void showDatePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog=new DatePickerDialog(HomeActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edFecha.setText(year+"-"+(month+1)+"-"+dayOfMonth);

            }
        },year,month,dayOfMonth);
        dialog.show();
    }
}