package com.example.adri9ps.mysqliteproyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FlitrosBusqueda extends AppCompatActivity {

    CheckBox estudiante, profesor;
    EditText curso, ciclo;
    Button filtro;
    ArrayList <String> listaE_Filtros;
    ArrayList <String> listaP_Filtros;

    ListView lvEstudiantes,lvProfesores;
    public ArrayAdapter adapterE_Filtros;
    public ArrayAdapter adapterP_Filtros;

    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flitros_busqueda);
        estudiante = (CheckBox) findViewById(R.id.boxEstudiantes);
        profesor = (CheckBox) findViewById(R.id.boxProfesores);
        curso = (EditText) findViewById(R.id.editFiltroCurso);
        ciclo = (EditText) findViewById(R.id.editFiltroCiclo);
        filtro = (Button) findViewById(R.id.btnAplicarFiltros);
        db = new DB(getApplicationContext(), null, null, 1);
        lvEstudiantes = (ListView) findViewById(R.id.listEstudiantes);
        lvProfesores = (ListView) findViewById(R.id.listProfesores);


        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recargarVista();
            }
        });

    }








    private void recargarVista() {
            if (estudiante.isChecked()){
                lvEstudiantes.setVisibility(View.VISIBLE);

                String filtros = " WHERE ";
                if (ciclo.getText().toString().length() > 0){
                    filtros += "ciclo_e='" + ciclo.getText().toString() + "'";
                }

                if (ciclo.getText().toString().length() > 0 && curso.getText().toString().length() > 0){
                    filtros += " AND ";
                }

                if (curso.getText().toString().length() > 0){
                    filtros += "curso_e='" + curso.getText().toString() + "'";
                }

                //Evaluador FINAL de filtros
                if (!filtros.equals(" WHERE ")){
                    //Se han modificado filtros
                    listaE_Filtros = db.filtroEstudiantes(filtros);
                } else {
                    //No se han añadido filtros
                    listaE_Filtros = db.llenar_lvEstudiantes();
                }

                adapterE_Filtros = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaE_Filtros);
                lvEstudiantes.setAdapter(adapterE_Filtros);

            } else {
                lvEstudiantes.setVisibility(View.GONE);
            }

            if (profesor.isChecked()){
                lvProfesores.setVisibility(View.VISIBLE);

                String filtros = " WHERE ";
                if (ciclo.getText().toString().length() > 0){
                    filtros += "ciclo_p='" + ciclo.getText().toString() + "'";
                }

                if (ciclo.getText().toString().length() > 0 && curso.getText().toString().length() > 0){
                    filtros += " AND ";
                }

                if (curso.getText().toString().length() > 0){
                    filtros += "curso_p='" + curso.getText().toString() + "'";
                }

                //Evaluador FINAL de filtros
                if (!filtros.equals(" WHERE ")){
                    //Se han modificado filtros
                    listaP_Filtros = db.filtroProfesores(filtros);
                } else {
                    //No se han añadido filtros
                    listaP_Filtros = db.llenar_lvProfesores();
                }

                adapterP_Filtros = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaP_Filtros);
                lvProfesores.setAdapter(adapterP_Filtros);
            } else {
                lvProfesores.setVisibility(View.GONE);
            }
        }

    }

