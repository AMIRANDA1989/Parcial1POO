/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

import java.util.Scanner;

/**
 *
 * @author allan
 */
public class Habitacion {
    private String codHabitacion; //Codigo de la habitacion
    private boolean habilitado; //Indicador si esta habilitada la habitacion
    private int capacidad;  //Capacidad de clientes de la habitacion, puede ser una o dos personas OJO:Las habitaciones con numero par deben ser dobles
    private boolean disponible; //Indica si se puede utilizar la habitacion en caso de reserva o venta
    Scanner in = new Scanner(System.in); //Sirve para leer el input del usuario

    public Habitacion() {
        
    }

    public String getCodHabitacion() {
        return codHabitacion;
    }

    public void setCodHabitacion(String codHabitacion) {
        this.codHabitacion = codHabitacion;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
}
