package com.iris.guia02_labdis;

import androidx.appcompat.app.AppCompatActivity;
import static com.iris.guia02_labdis.MainActivity.lstPersonas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iris.guia02_labdis.Clase.Persona;

public class AgregarPersonaActivity extends AppCompatActivity {
    EditText EditarNombre, EditarApellido, EditarEdad, EditarCorreo;
    Button BotonPro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        EditarNombre = findViewById(R.id.EditarNombre);
        EditarApellido = findViewById(R.id.EditarApellido);
        EditarEdad = findViewById(R.id.EditarEdad);
        EditarCorreo = findViewById(R.id.EditarCorreo);
        BotonPro = findViewById(R.id.BotonPro);

        BotonPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstPersonas.add(new Persona(lstPersonas.size() + 1, EditarNombre.getText().toString(),
                        EditarApellido.getText().toString(), Integer.parseInt(EditarEdad.getText().toString()),
                        EditarCorreo.getText().toString()));

                Toast.makeText(AgregarPersonaActivity.this, "Dato insertado exitosamente.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}