package com.example.registronotas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AyudaActivity extends AppCompatActivity {

    private Button boton_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        boton_regresar = (Button) findViewById(R.id.btn_regresar);

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
        if(id == R.id.actionbar_registrar){
            lanzarRegistrar(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void lanzarHome(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void lanzarVerificar(View view){
        Intent i = new Intent(this,VerificarActivity.class);
        startActivity(i);
    }
    public void lanzarRegistrar(View view){
        Intent i = new Intent(this,RegistrarActivity.class);
        startActivity(i);
    }

}
