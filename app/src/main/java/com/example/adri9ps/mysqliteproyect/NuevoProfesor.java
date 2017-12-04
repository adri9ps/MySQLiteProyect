package com.example.adri9ps.mysqliteproyect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoProfesor extends AppCompatActivity {
    EditText Enombre_p, Eedad_p, Ecurso_p, Eciclo_p, Edespacho_p;
    Button enviarProfesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_profesor);

        //Asignamos
        Enombre_p = (EditText) findViewById(R.id.editnombreP);
        Eedad_p = (EditText) findViewById(R.id.editapellidoP);
        Ecurso_p = (EditText) findViewById(R.id.editcursoP);
        Eciclo_p = (EditText) findViewById(R.id.editcicloP);
        Edespacho_p = (EditText) findViewById(R.id.editmediaP);
        enviarProfesor = (Button) findViewById(R.id.btnENVIARProfesor);

        enviarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Enombre_p.getText().toString().isEmpty() || Eedad_p.getText().toString().isEmpty() ||
                        Eciclo_p.getText().toString().isEmpty() || Ecurso_p.getText().toString().isEmpty()
                        || Edespacho_p.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();

                }else {
                    DB db = new DB(getApplicationContext(), null, null, 1);
                    String nombre = Enombre_p.getText().toString();
                    String edad = Eedad_p.getText().toString();
                    String curso = Ecurso_p.getText().toString();
                    String ciclo = Eciclo_p.getText().toString();
                    String despacho = Edespacho_p.getText().toString();
                    String mensaje = db.guardarProfesores(nombre, edad, curso, ciclo, despacho);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }
}
