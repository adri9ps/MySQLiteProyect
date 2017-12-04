package com.example.adri9ps.mysqliteproyect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarProfesor extends AppCompatActivity {

    EditText idP;
    Button eliminarProfesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_profesor);

        idP = (EditText) findViewById(R.id.editText_ID_P);
        eliminarProfesor = (Button) findViewById(R.id.btn_ELIMINARPROFESOR);

        eliminarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idP.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Introduce un ID", Toast.LENGTH_SHORT).show();

                }else {

                    DB db = new DB(getApplicationContext(), null, null, 1);
                    String idEstu = idP.getText().toString();
                    Integer id = Integer.valueOf(idEstu);
                    String mensaje = db.eliminarProfesor(id);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
