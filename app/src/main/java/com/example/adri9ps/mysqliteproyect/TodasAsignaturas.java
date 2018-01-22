package com.example.adri9ps.mysqliteproyect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TodasAsignaturas extends AppCompatActivity {

    private ListView lvAsig;
    ArrayList<String> listaA_Filtros;
    public ArrayAdapter adapterA_Filtros;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_asignaturas);


        lvAsig = (ListView) findViewById(R.id.listAsignaturas);
        db = new DB(getApplicationContext(), null, null, 1);




                listaA_Filtros = db.llenar_lvAsignaturas();


            adapterA_Filtros = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaA_Filtros);
            lvAsig.setAdapter(adapterA_Filtros);




    }
}
