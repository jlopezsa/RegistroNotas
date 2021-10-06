package com.example.registronotas;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String nombre;
    private Corte notas_corte;
    private float total_corte;

    public Estudiante(){
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNotas_corte(Corte notas_corte) {
        this.notas_corte = notas_corte;
    }

    public Corte getNotas_corte() {
        return notas_corte;
    }

    public void calculatotal_corte() {
        total_corte = (float)(0.3*notas_corte.getTrabajos() + 0.3*notas_corte.getAutoevaluacion() + 0.4*notas_corte.getParcial());
    }
    public float getTotal_corte() {
        return total_corte;
    }
}
