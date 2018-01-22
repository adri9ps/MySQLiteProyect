package com.example.adri9ps.mysqliteproyect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button nuevoEstudiante;
    Button eliminarEstudiante;
    Button nuevoProfesor;
    Button eliminarProfesor;
    Button filtroTotal;
    Button asignaturas;
    Button Nuevaasignaturas;
    final static int SUBACT_1 = 365;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos
        nuevoEstudiante = (Button) findViewById(R.id.btnAñadirEstudiante);
        nuevoProfesor = (Button) findViewById(R.id.btnAñadirProfesor);
        eliminarEstudiante = (Button) findViewById(R.id.btnEliminarEstudiante);
        eliminarProfesor = (Button) findViewById(R.id.btnEliminarProfesor);
        nuevoEstudiante = (Button) findViewById(R.id.btnAñadirEstudiante);
        nuevoProfesor = (Button) findViewById(R.id.btnAñadirProfesor);
        filtroTotal = (Button) findViewById(R.id.btnFiltrar);
        asignaturas = (Button) findViewById(R.id.btnTodasLasAsignaturas);
        Nuevaasignaturas = (Button) findViewById(R.id.btnNuevaAsig);


        nuevoEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NuevoEstudiante.class);
                startActivityForResult(i, SUBACT_1);
            }
        });
        eliminarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EliminarEstudiante.class);
                startActivityForResult(i, SUBACT_1);
            }
        });
        nuevoProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NuevoProfesor.class);
                startActivityForResult(i, SUBACT_1);
            }
        });
        eliminarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EliminarProfesor.class);
                startActivityForResult(i, SUBACT_1);
            }
        });
        filtroTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FlitrosBusqueda.class);
                startActivityForResult(i, SUBACT_1);

            }
        });

        Nuevaasignaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NuevaAsignatura.class);
                startActivityForResult(i, SUBACT_1);

            }
        });
        asignaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TodasAsignaturas.class);
                startActivityForResult(i, SUBACT_1);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
