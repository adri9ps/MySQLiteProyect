package com.example.adri9ps.mysqliteproyect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevaAsignatura extends AppCompatActivity {

    private EditText nombre_a, horas_a;
    private Button enviarAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_asignatura);

        nombre_a = (EditText) findViewById(R.id.editnombreA);
        horas_a = (EditText) findViewById(R.id.editHorasA);
        enviarAsignatura = (Button) findViewById(R.id.btnENVIARAsignatura);

        enviarAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre_a.getText().toString().isEmpty() || horas_a.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();

                } else {
                    DB db = new DB(getApplicationContext(), null, null, 1);
                    String nombre = nombre_a.getText().toString();
                    String horas = horas_a.getText().toString();
                    String mensaje = db.guardarAsignaturas(nombre, horas);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
