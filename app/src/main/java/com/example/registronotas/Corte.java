package com.example.registronotas;

import java.io.Serializable;

public class Corte implements Serializable {
    private float trabajos;
    private float autoevaluacion;
    private float parcial;
    

    public Corte(){

    }
    public Corte(float trabajos, float autoevaluacion, float parcial){
        this.trabajos = trabajos;
        this.autoevaluacion = autoevaluacion;
        this.parcial = parcial;
    }

    public void setTrabajos(float trabajos) {

        this.trabajos = trabajos;
    }
    public float getTrabajos() {

        return trabajos;
    }

    public void setAutoevaluacion(float autoevaluacion) {

        this.autoevaluacion = autoevaluacion;
    }
    public float getAutoevaluacion() {

        return autoevaluacion;
    }

    public void setParcial(float parcial) {

        this.parcial = parcial;
    }
    public float getParcial() {

        return parcial;
    }
}
