package com.example.registronotas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrarActivity extends Activity {

    private Materia materia_reg;
    private Estudiante estudiante_reg;
    private Corte corte_notas;

    private TextView ingresa_disciplina, ingresa_estudiante;
    private TextView in_autoevaluacion, in_trabajos, in_parcial;
    private Button boton_reg_alumno, boton_reg_notas, boton_regresar;

    private int contador = 0;


    @Override public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_registrar);

        ingresa_disciplina = (TextView)findViewById(R.id.txt_disciplina);
        ingresa_estudiante = (TextView)findViewById(R.id.txt_alumno);
        in_autoevaluacion = (TextView)findViewById(R.id.txt_autoevaluacion);
        in_trabajos = (TextView)findViewById(R.id.txt_trabajos);
        in_parcial = (TextView)findViewById(R.id.txt_parcial);

        boton_reg_alumno = (Button)findViewById(R.id.btn_ingresa_alumno);
        boton_reg_notas = (Button)findViewById(R.id.btn_notas);
        boton_regresar = (Button)findViewById(R.id.btn_regresar);

        materia_reg = new Materia();
        estudiante_reg = new Estudiante();
        corte_notas = new Corte();

        Log.i("FLAG1","Fuera boton");

        boton_reg_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia_reg.setNombre_materia(ingresa_disciplina.getText().toString());
                estudiante_reg.setNombre(ingresa_estudiante.getText().toString());

                Log.i("FLAG1",materia_reg.getNombre_materia());
                Log.i("FLAG1",estudiante_reg.getNombre());
            }
        });

        boton_reg_notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corte_notas.setAutoevaluacion(Float.valueOf(in_autoevaluacion.getText().toString()));
                corte_notas.setTrabajos(Float.valueOf(in_trabajos.getText().toString()));
                corte_notas.setParcial(Float.valueOf(in_parcial.getText().toString()));

                estudiante_reg.setNotas_corte(corte_notas);
                materia_reg.setEstudiantes(estudiante_reg);
                estudiante_reg.calculatotal_corte();

                Log.i("FLAG2",String.valueOf(materia_reg.getEstudiantes(contador).getNombre()));
                contador++;
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
        Bundle bundle = new Bundle();
        bundle.putSerializable("MATERIA", materia_reg);
        startActivity(i);
    }

}
