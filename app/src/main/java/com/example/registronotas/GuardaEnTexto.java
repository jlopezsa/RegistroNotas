package com.example.registronotas;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GuardaEnTexto {
    private static String FICHERO = "datos_estudiante.txt";
    private Context context;

    public GuardaEnTexto(Context context){
        this.context = context;
    }

    public void escribeArchivo(Estudiante estudiantes) {
        try {
            FileOutputStream f = context.openFileOutput(FICHERO, Context.MODE_APPEND);
            String texto = estudiantes.getNombre()+";"+estudiantes.getTotal_corte()+";"+estudiantes.getNotas_corte().getParcial()+"\n"; // <---  Datos para guardar en archivo <----
            f.write(texto.getBytes());
            f.close();
        }catch(Exception e){
            Log.e("GUARDA-WRITE",e.getMessage(),e);
        }
    }

    public List<String> leeArchivo(){
        List<String> resultado = new ArrayList<String>();
        try {
            FileInputStream f = context.openFileInput(FICHERO);
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

    public void limpiaArchivo(){
        try {
            FileOutputStream f = context.openFileOutput(FICHERO,Context.MODE_APPEND);
            f.write(("").getBytes());
            f.close();
        }catch(Exception e){
            Log.e("GUARDA-WRITE",e.getMessage(),e);
        }
    }
}
