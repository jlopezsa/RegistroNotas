package com.example.registronotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boton_registrar;
    private Button boton_verificar;
    private Button boton_ayuda;
    private Materia materia_reg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton_registrar = (Button) findViewById(R.id.btn_registrar);
        boton_verificar = (Button) findViewById(R.id.btn_verificar);
        boton_ayuda = (Button) findViewById(R.id.btn_ayuda);

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

        boton_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarAyuda(null);
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

    public void lanzarRegistrar(View view){
        Intent i = new Intent(this,RegistrarActivity.class);
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