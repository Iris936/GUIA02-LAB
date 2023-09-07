package com.iris.guia02_labdis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.iris.guia02_labdis.Clase.Persona;
import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        public static ArrayList<Persona> lstPersonas = new ArrayList<>();
        private ListView rPersona;
        private Button BotonAgregarPersona, BotonMostrar,BotonAcercaDe;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            BotonAgregarPersona = findViewById(R.id.BotonAgregar);

            BotonMostrar = findViewById(R.id.BotonMostrar);

            BotonAcercaDe = findViewById(R.id.BotonAcercaDe);

            BotonAgregarPersona.setOnClickListener(v -> {
                startActivity(new Intent(MainActivity.this, AgregarPersonaActivity.class));
            });

            BotonMostrar.setOnClickListener(v -> {
                startActivity(new Intent(MainActivity.this, MostrarPersonaActivity.class));

            });
            BotonAcercaDe.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, AcercaDeActivity.class);
                    startActivity(intent);
                }
            });

        }
        private void llenarLista(){
            lstPersonas.add(new Persona(lstPersonas.size() + 1, "Iris", "Calderon", 21, "iriscalderon@gmail.com"));
        }
        @Override
        protected void onStart() {
            super.onStart();
        }
        @Override
        protected void onResume() {
            super.onResume();
        }
        @Override
        protected void onPause() {
            super.onPause();
        }
        @Override
        protected void onDestroy() {
            super.onDestroy();
        }
        @Override
        protected void onRestart() {
            super.onRestart();
        }
    }