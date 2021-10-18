package com.example.registronotas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class VerificarActivity extends AppCompatActivity {

    private TextView muestra_resultado;
    private Button boton_ver_datos;
    private Materia materia_reg;
    private GuardaEnTexto leerDatos = new GuardaEnTexto(this);

    @Override public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_verificar);

        //Log.i("VERIFICAR","Flag 1");

        muestra_resultado = (TextView)findViewById(R.id.txt_visualizar);
        boton_ver_datos = (Button)findViewById(R.id.btn_ver_notas);

        // Recibiendo objeto desde Main
        Bundle objeto_rx_of_main = getIntent().getExtras();
        if(objeto_rx_of_main!=null){
            materia_reg = (Materia) objeto_rx_of_main.getSerializable("MATERIA");
        }

        materia_reg = new Materia();

        boton_ver_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(materia_reg!=null){
                    for (int i = 0; i < materia_reg.getTotal_estudiantes(); i++) {
                        muestra_resultado.append(materia_reg.getEstudiantes(i).getNombre()+ getString(R.string.tab)+
                                materia_reg.getEstudiantes(i).getTotal_corte()+"\n");
                    }
                }
                else{*/
                muestra_resultado.setText("");
                SimpleDateFormat formatoHoraFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                formatoHoraFecha.setTimeZone(TimeZone.getTimeZone("GMT-5"));
                String timeStamp = formatoHoraFecha.format(Calendar.getInstance().getTime());
                muestra_resultado.append(timeStamp+"\n");

                //    muestra_resultado.setText("Alumnos no registrados \n");
                //    muestra_resultado.append("Intente de nuevo \n");

                    List<String> ver_datos = leerDatos.leeArchivo();
                    //Log.i("VERIFICAR",String.valueOf(ver_datos.size()));
                    for (int i = 0; i < ver_datos.size(); i++) {
                        Log.i("VERIFICAR",ver_datos.get(i)+"\n");
                        muestra_resultado.append(ver_datos.get(i)+"\n");
                        //Log.i("VERIFICAR",String.valueOf(i));

                    }



                //}
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
        if(id == R.id.actionbar_registrar){
            lanzarRegistrar(null);
            return true;
        }
        if(id == R.id.actionbar_ayuda){
            lanzarAyuda(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void lanzarRegistrar(View view){
        Intent i = new Intent(this,RegistrarActivity.class);
        startActivity(i);
    }
    public void lanzarAyuda(View view){
        Intent i = new Intent(this,AyudaActivity.class);
        startActivity(i);
    }

}
