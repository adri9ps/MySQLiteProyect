package com.example.adri9ps.mysqliteproyect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarEstudiante extends AppCompatActivity {
    EditText idE;
    Button eliminarEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_estudiante);

        idE = (EditText) findViewById(R.id.editText_ID_E);
        eliminarEstudiante = (Button) findViewById(R.id.btn_ELIMINARESTUDIANTE);

        eliminarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idE.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Introduce un ID", Toast.LENGTH_SHORT).show();

                } else {
                    DB db = new DB(getApplicationContext(), null, null, 1);
                    String idEstu = idE.getText().toString();
                    Integer id = Integer.valueOf(idEstu);
                    String mensaje = db.eliminarEstudiante(id);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
