package com.example.registronotas;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

    public class GuardaEnTexto {
    //private static String FICHERO = "datos_estudiante.txt";
    private static String FICHERO = Environment.getExternalStorageDirectory().getPath()+"/datos_fichero.txt";

    private Context context;

    public GuardaEnTexto(Context context){
        this.context = context;
    }

    public void escribeArchivo(Estudiante estudiantes) {
        try {
            String stadoSD = Environment.getExternalStorageState();
            if(!stadoSD.equals(Environment.MEDIA_MOUNTED)){
                Toast.makeText(context,"No puede leer la memoria externa",Toast.LENGTH_LONG).show();
                return;
            }
            //FileOutputStream f = context.openFileOutput(FICHERO, Context.MODE_APPEND);
            FileOutputStream f = new FileOutputStream(FICHERO,true);
            // La siguiente linea muestra como guardar los datos en el archivo <----
            String texto = estudiantes.getNombre()+";"+estudiantes.getTotal_corte()+";"+estudiantes.getNotas_corte().getParcial()+"\n";
            f.write(texto.getBytes());
            f.close();
        }catch(Exception e){
            Log.e("GUARDA-WRITE",e.getMessage(),e);
        }
    }
    /*
    public void limpiaArchivo(){
        try {
            String stadoSD = Environment.getExternalStorageState();
            if(!stadoSD.equals(Environment.MEDIA_MOUNTED)){
                Toast.makeText(context,"No puede leer la memoria externa",Toast.LENGTH_LONG).show();
                return;
            }
            //FileOutputStream f = context.openFileOutput(FICHERO,Context.MODE_APPEND);
            FileOutputStream f = new FileOutputStream(FICHERO,true);
            String texto = "";
            f.write(texto.getBytes());

            f.close();
        }catch(Exception e){
            Log.e("GUARDA-WRITE",e.getMessage(),e);
        }
    }
    */

    public void limpiaArchivo(){

        try {
            String stadoSD = Environment.getExternalStorageState();
            if(!stadoSD.equals(Environment.MEDIA_MOUNTED)){
               Toast.makeText(context,"No puede leer la memoria externa",Toast.LENGTH_LONG).show();
               return;
            }
            PrintWriter archivo = new PrintWriter(new FileWriter(FICHERO));
        }catch(Exception e){
            Log.e("MATERIA-READ",e.getMessage(),e);
        }
    }


    public List<String> leeArchivo(){
        List<String> resultado = new ArrayList<String>();
        try {
            //FileInputStream f = context.openFileInput(FICHERO);
            FileInputStream f = new FileInputStream(FICHERO);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(f));
            int n = 0;
            String linea;
            do {
                linea = entrada.readLine();
                if (linea != null){
                    resultado.add(linea);
                    n++;
                }
            }while(linea != null);
            //while(n<total_estudiantes && linea != null);
            f.close();
        }catch(Exception e){
            Log.e("MATERIA-READ",e.getMessage(),e);
        }
        return resultado;
    }



    public String getFICHERO(){
        return FICHERO;
    }


}
