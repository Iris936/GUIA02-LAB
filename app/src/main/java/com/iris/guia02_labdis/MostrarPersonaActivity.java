package com.iris.guia02_labdis;

import static com.iris.guia02_labdis.MainActivity.lstPersonas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iris.guia02_labdis.Clase.Persona;

public class MostrarPersonaActivity extends AppCompatActivity {
    private ListView nPersonas;
    private ArrayAdapter<Persona> arrayAdapter;
    private static final int EDITAR_PERSONA_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_persona2);

        nPersonas = findViewById(R.id.rPersona);

        arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, lstPersonas);

        nPersonas.setAdapter(arrayAdapter);

        nPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Persona personaParaEditar = lstPersonas.get(position);


                Intent intent = new Intent(MostrarPersonaActivity.this, EditarPersonaActivity.class);


                intent.putExtra("PersonaEditar", personaParaEditar);


                startActivityForResult(intent, EDITAR_PERSONA_REQUEST);
            }
        });

        nPersonas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final Persona personaParaEliminar = lstPersonas.get(position);


                AlertDialog.Builder builder = new AlertDialog.Builder(MostrarPersonaActivity.this);
                builder.setTitle("Eliminar");
                builder.setMessage("¿Quieres eliminar a este registro?");


                builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        lstPersonas.remove(personaParaEliminar);

                        arrayAdapter.notifyDataSetChanged();
                    }
                });


                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });
                builder.create().show();

                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDITAR_PERSONA_REQUEST && resultCode == RESULT_OK && data != null) {
            Persona personaEditada = data.getParcelableExtra("PersonaEditada");
            if (personaEditada != null) {
                for (int i = 0; i < lstPersonas.size(); i++) {
                    if (lstPersonas.get(i).getIdPersona() == personaEditada.getIdPersona()) {
                        lstPersonas.set(i, personaEditada);
                        break;
                    }
                }
                arrayAdapter.notifyDataSetChanged();
            }
        }
    }
}