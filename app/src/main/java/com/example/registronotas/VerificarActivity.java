package com.example.registronotas;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class VerificarActivity extends AppCompatActivity {

    private TextView muestra_resultado;
    private Button boton_ver_datos;
    private Button boton_enviar_correo;
    private List<String> ver_datos;
    //private ListView lista_pantalla;


    private Materia materia_reg;
    private GuardaEnTexto leerDatos = new GuardaEnTexto(this);

    @Override public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_verificar);

        //Log.i("VERIFICAR","Flag 1");

        muestra_resultado = (TextView)findViewById(R.id.txt_visualizar);
        muestra_resultado.setMovementMethod(new ScrollingMovementMethod()); // adicionar para scroll

        //lista_pantalla = (ListView)findViewById(R.id.txt_lista);

        boton_ver_datos = (Button)findViewById(R.id.btn_ver_notas);
        boton_enviar_correo = (Button)findViewById(R.id.btn_enviar_correo);

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

                //muestra_resultado.setText("Alumnos no registrados \n");
                //muestra_resultado.append("Intente de nuevo \n");

                ver_datos = leerDatos.leeArchivo();
                for (int i = 0; i < ver_datos.size(); i++) {
                    // Muestra información del archivo txt en un TextView.
                    muestra_resultado.append(ver_datos.get(i)+"\n");

                    // Extraer datos del archivo txt para procesarlos en el código
                    // dato_linea: guarda la información de la linea i del archivo txt
                    String dato_linea = ver_datos.get(i);
                    // datos_separados: es un vector que guarda los datos de la línea separados por ";"
                    String [] datos_separados = dato_linea.split(";");

                    // Las siguientes líneas muestran como manipular los datos de la línea de forma individual
                    Log.i("Primer dato de la línea",datos_separados[0]);
                    Log.i("Segundo dato de la línea",datos_separados[1]);
                    float aux_nota = Float.valueOf(datos_separados[2]);
                    Log.i("Tercer dato de la línea x 2",String.valueOf(aux_nota*2));

                    // Forma de comparar un String del archivo txt con una palabra cualquier, ejemplo "Carlos"
                    if(datos_separados[0].equals("Carlos")){
                        Log.i("COMPARA","Carlos está en la linea " +String.valueOf(i)+" del texto");
                    }
                    else {
                        Log.i("COMPARA","Carlos NO está en la linea "+String.valueOf(i)+" del texto");
                    }
                }
                //}
            }
        });

        boton_enviar_correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarCorreo();
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

    private void enviarCorreo(){
        //https://coderedirect.com/questions/552769/how-to-share-txt-file-in-android
        File file = new File(Environment.getExternalStorageDirectory().toString() + "/" + "datos_fichero.txt");
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + file.getAbsolutePath()));
        startActivity(Intent.createChooser(sharingIntent, "Enviar archivo usando:"));
    }
}
