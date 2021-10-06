package com.example.registronotas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrarActivity extends Activity {

    private Materia materia_reg;
    private Estudiante estudiante_reg;
    private Corte corte_notas;

    private Button boton_regresar, boton_reg_alumno,boton_reg_notas;
    private EditText ingresa_disciplina;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_registrar);

        materia_reg = new Materia();



        // Asociar objetos de la vista con el código
        ingresa_disciplina = (EditText) findViewById(R.id.txt_disciplina);

        boton_regresar = (Button)findViewById(R.id.btn_regresar);
        boton_reg_alumno = (Button)findViewById(R.id.btn_ingresa_alumno);
        boton_reg_notas = (Button)findViewById(R.id.btn_notas);
        //------------------------------------------


        // Creando los Listener de los botones
        boton_reg_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia_reg.setNombre_materia(ingresa_disciplina.getText().toString());
                Log.i("REGISTRAR",ingresa_disciplina.getText().toString());
                //Log.i("REGISTRAR",materia_reg.getNombre_materia());
                estudiante_reg = new Estudiante();

                // Adicionar código para ingresar el nombre del estudiante

                //estudiante_reg.setNombre(); // <------------------- Completar



            }
        });

        boton_reg_notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corte_notas = new Corte();

                // Adicionar código para ingresar Las nótas del estudiante

                //corte_notas.setAutoevaluacion();
                //corte_notas.setParcial();
                //corte_notas.setTrabajos();
            }
        });

        boton_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarHome(null);
            }
        });

    }

    public void lanzarHome(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
