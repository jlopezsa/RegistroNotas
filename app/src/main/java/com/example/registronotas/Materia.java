package com.example.registronotas;

import java.util.ArrayList;

public class Materia {

    private String nombre_materia;
    private ArrayList<Estudiante> estudiantes;
    private float nota_media;

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
}
