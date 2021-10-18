package com.example.registronotas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {

    private Materia materia_reg;
    private Estudiante estudiante_reg;
    private Corte corte_notas;
    private GuardaEnTexto guardar = new GuardaEnTexto(this);

    private TextView ingresa_disciplina, ingresa_estudiante;
    private TextView in_autoevaluacion, in_trabajos, in_parcial;
    private Button boton_reg_alumno, boton_reg_notas, boton_regresar;

    private int contador = 0;


    @Override
    public void onCreate(Bundle saveInstanceState){
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

        guardar.limpiaArchivo();

        boton_reg_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estudiante_reg = new Estudiante();
                materia_reg.setNombre_materia(ingresa_disciplina.getText().toString());
                estudiante_reg.setNombre(ingresa_estudiante.getText().toString());
            }
        });

        boton_reg_notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corte_notas = new Corte();
                try {
                    corte_notas.setAutoevaluacion(Float.valueOf(in_autoevaluacion.getText().toString()));
                    corte_notas.setTrabajos(Float.valueOf(in_trabajos.getText().toString()));
                    corte_notas.setParcial(Float.valueOf(in_parcial.getText().toString()));

                    if(corte_notas.getParcial()<0||corte_notas.getParcial()>5){
                        lanzaAdvertenciaFueraRano();
                    }
                    if(corte_notas.getAutoevaluacion()<0||corte_notas.getAutoevaluacion()>5){
                        lanzaAdvertenciaFueraRano();
                    }
                    if(corte_notas.getTrabajos()<0||corte_notas.getTrabajos()>5){
                        lanzaAdvertenciaFueraRano();
                    }
                }catch (Exception e){
                    Log.i("REGISTRAR","Ingrese numero real");
                    AlertDialog.Builder alerta = new AlertDialog.Builder(RegistrarActivity.this);
                    alerta.setMessage("Ingrese un numero real");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("Cuidado");
                    titulo.show();
                }


                estudiante_reg.setNotas_corte(corte_notas);
                materia_reg.setEstudiantes(estudiante_reg);
                estudiante_reg.calculatotal_corte();

                guardar.escribeArchivo(estudiante_reg);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.actionbar_verificar){
            lanzarVerificar(null);
            return true;
        }
        if(id == R.id.actionbar_ayuda){
            lanzarAyuda(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void lanzaAdvertenciaFueraRano(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(RegistrarActivity.this);
        alerta.setMessage("Notas Fuera del rango, las notas deben ser entre 0 y 5");
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Notas con error");
        titulo.show();
    }

    public void lanzarHome(View view){
        Intent i = new Intent(this,MainActivity.class);
        //Bundle bundle = new Bundle();
        //bundle.putSerializable("MATERIA", materia_reg);
        //i.putExtras(bundle);
        startActivity(i);
    }
    public void lanzarVerificar(View view){
        Intent i = new Intent(this,VerificarActivity.class);
        //Bundle bundle = new Bundle();
        //bundle.putSerializable("MATERIA", materia_reg);
        //i.putExtras(bundle);
        startActivity(i);
    }
    public void lanzarAyuda(View view){
        Intent i = new Intent(this,AyudaActivity.class);
        startActivity(i);
    }

}
