package com.example.registronotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boton_registrar;
    private Button boton_verificar;
    private Materia materia_reg = null;
    private Bundle objeto_rx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton_registrar = (Button) findViewById(R.id.btn_registrar);
        boton_verificar = (Button) findViewById(R.id.btn_verificar);

        // Recibiendo el objeto desde otra actividad
        Bundle objeto_rx = getIntent().getExtras();
        if(objeto_rx!=null){
            materia_reg = (Materia) objeto_rx.getSerializable("MATERIA");
        }

        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarRegistrar(null);
            }
        });

        boton_verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarVerificar(null);
            }
        });
    }

    public void lanzarRegistrar(View view){
        Intent i = new Intent(this,RegistrarActivity.class);
        startActivity(i);
    }

    public void lanzarVerificar(View view){
        Intent i = new Intent(this,VerificarActivity.class);
        // Enviando un objeto para otra actividad
        //if(materia_reg!=null){
            Bundle bundle = new Bundle();
            bundle.putSerializable("MATERIA_VERIFICAR", materia_reg);
            i.putExtras(bundle);
        //}
        startActivity(i);
    }
}