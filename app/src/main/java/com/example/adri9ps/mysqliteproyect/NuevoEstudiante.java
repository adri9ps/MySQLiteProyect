package com.example.adri9ps.mysqliteproyect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NuevoEstudiante extends AppCompatActivity {

    EditText Enombre, Eedad, Ecurso, Eciclo, Emedia;
    Button enviarEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_estudiante);

        //Asignamos
        Enombre = (EditText) findViewById(R.id.editnombreE);
        Eedad = (EditText) findViewById(R.id.editEdadE);
        Ecurso = (EditText) findViewById(R.id.editcursoE);
        Eciclo = (EditText) findViewById(R.id.editcicloE);
        Emedia = (EditText) findViewById(R.id.editmediaE);
        enviarEstudiante = (Button) findViewById(R.id.btnENVIAREstudiante);

        enviarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Enombre.getText().toString().isEmpty() || Eedad.getText().toString().isEmpty() ||
                        Eciclo.getText().toString().isEmpty() || Ecurso.getText().toString().isEmpty()
                        || Emedia.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();

                } else {
                    DB db = new DB(getApplicationContext(), null, null, 1);
                    String nombre = Enombre.getText().toString();
                    String edad = Eedad.getText().toString();
                    String curso = Ecurso.getText().toString();
                    String ciclo = Eciclo.getText().toString();
                    String nota_media = Emedia.getText().toString();
                    String mensaje = db.guardarEstudiantes(nombre, edad, curso, ciclo, nota_media);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

}

