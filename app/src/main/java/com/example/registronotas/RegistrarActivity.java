package com.example.registronotas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrarActivity extends Activity {

    private Materia materia_reg;
    private TextView ingresa_disciplina;
    private Button boton_reg_alumno;

    @Override public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_registrar);

        ingresa_disciplina = (TextView)findViewById(R.id.txt_disciplina);
        boton_reg_alumno = (Button)findViewById(R.id.btn_ingresa_alumno);

        materia_reg = new Materia();
        Log.i("FLAG1","Fuera boton");

        boton_reg_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia_reg.setNombre_materia(ingresa_disciplina.getText().toString());

                Log.i("FLAG1",materia_reg.getNombre_materia());
            }
        });


    }

}
