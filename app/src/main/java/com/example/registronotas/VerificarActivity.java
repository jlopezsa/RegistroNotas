package com.example.registronotas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class VerificarActivity extends Activity {

    private TextView muestra_resultado;
    private RecyclerView pantalla;
    private Button boton_ver_datos;
    private Materia materia_reg = null;

    @Override public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_verificar);

        //Log.i("VERIFICAR","Flag 1");

        muestra_resultado = (TextView)findViewById(R.id.txt_visualizar);
        boton_ver_datos = (Button)findViewById(R.id.btn_ver_notas);

        // Recibiendo objeto desde Main
        Bundle objeto_rx_of_main = getIntent().getExtras();
        if(objeto_rx_of_main!=null){
            materia_reg = (Materia) objeto_rx_of_main.getSerializable("MATERIA_VERIFICAR");
        }

        boton_ver_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(materia_reg!=null){
                    for (int i = 0; i < materia_reg.getTotal_estudiantes(); i++) {
                        muestra_resultado.append(materia_reg.getEstudiantes(i).getNombre()+ getString(R.string.tab)+
                                materia_reg.getEstudiantes(i).getTotal_corte()+"\n");
                    }
                }
                else{
                    muestra_resultado.setText("Alumnos no registrados \n");
                    muestra_resultado.append("Intente de nuevo");
                }
            }
        });
    }
}
