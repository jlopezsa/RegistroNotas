package com.example.registronotas;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Materia /*implements Serializable*/ {

    private String nombre_materia;
    private ArrayList<Estudiante> estudiantes;
    private float nota_media;
    private int total_estudiantes;

    public Materia(){
        estudiantes = new ArrayList<Estudiante>();
    }
    public Materia(String nombre_materia){  
        this.nombre_materia = nombre_materia;
        estudiantes = new ArrayList<Estudiante>();
        nota_media = 0;
    }

    public void setNombre_materia(String nombre_materia) {

        this.nombre_materia = nombre_materia;
    }
    public String getNombre_materia() {

        return nombre_materia;
    }

    public void setEstudiantes(Estudiante estudiantes) {
        this.estudiantes.add(estudiantes);
    }
    public Estudiante getEstudiantes(int i) {
        return estudiantes.get(i);
    }

    public int getTotal_estudiantes(){
        total_estudiantes = estudiantes.size();
        return total_estudiantes;
    }


}
