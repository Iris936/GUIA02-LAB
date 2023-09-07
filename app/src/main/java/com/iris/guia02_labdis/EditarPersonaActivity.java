package com.iris.guia02_labdis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.iris.guia02_labdis.Clase.Persona;

public class EditarPersonaActivity extends AppCompatActivity {
    private EditText EditarNombre, EditarApellido, EditarEdad, EditarCorreo;
    private Button BotonGuardar;
    private Persona PersonaEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);

        EditarNombre = findViewById(R.id.EditarNombre);
        EditarApellido = findViewById(R.id.EditarApellido);
        EditarEdad = findViewById(R.id.EditarEdad);
        EditarCorreo = findViewById(R.id.EditarCorreo);
        BotonGuardar = findViewById(R.id.BotonGuardar);

        PersonaEditar = getIntent().getParcelableExtra("PersonaEditar");

        if (PersonaEditar != null) {

            EditarNombre.setText(PersonaEditar.getNombrePersona());
            EditarApellido.setText(PersonaEditar.getApellidoPersona());
            EditarEdad.setText(String.valueOf(PersonaEditar.getEdadPersona()));
            EditarCorreo.setText(PersonaEditar.getCorreoPersona());
        }

        BotonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (PersonaEditar != null) {
                    PersonaEditar.setNombrePersona(EditarNombre.getText().toString());
                    PersonaEditar.setApellidoPersona(EditarApellido.getText().toString());
                    PersonaEditar.setEdadPersona(Integer.parseInt(EditarEdad.getText().toString()));
                    PersonaEditar.setCorreoPersona(EditarCorreo.getText().toString());

                    Toast.makeText(EditarPersonaActivity.this, "Cambios guardados exitosamente.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.putExtra("PersonaEditada", PersonaEditar);
                    setResult(RESULT_OK, intent);

                    finish();
                }
            }
        });
    }
}