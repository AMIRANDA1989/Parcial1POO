/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author allan
 */
public class Piso {
    private String codPiso;
    private boolean habilitado;
    public ArrayList<Habitacion> habitaciones = new ArrayList();
    Scanner in = new Scanner(System.in); //Sirve para leer el input del usuario

    public Piso() {
    }

    public String getCodPiso() {
        return codPiso;
    }

    public void setCodPiso(String codPiso) {
        this.codPiso = codPiso;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
        
        //Si el piso está deshabilitado, entonces hay que deshabilitar las habitaciones
        if(!(this.habilitado)){
            for(int i = 0; i < habitaciones.size(); i++){
                habitaciones.get(i).setHabilitado(false);
            }  
        }else{
            for(int i = 0; i < habitaciones.size(); i++){
                habitaciones.get(i).setHabilitado(true);
            } 
        }
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void getRoomsStatus(){
        System.out.println("Estado de las habitaciones");
        
        for(Habitacion h : this.habitaciones){
            System.out.println("Habitacion: " + h.getCodHabitacion() + " Habilitado: " + h.isHabilitado() + " Disponible: " + h.isDisponible() );
        }
    }
    
    public void adminHabitaciones(){
        String option;
        boolean admStats = true;
        
        while(admStats){
            System.out.println("");
            System.out.println("");
            System.out.println("*****HOTEL VIÑA RAFINHA*****");
            System.out.println("**ADMINISTRACION DE HABITACIONES**");
            System.out.println("Seleccione la operacion que desea hacer:");
            System.out.println("1 - Revisar estado de habitaciones.");
            System.out.println("2 - Habilitar/desabilitar habitacion.");
            System.out.println("3 - Regresar");
            
            option = in.nextLine();
            
            switch (option){
                case "1":
                    for(int i = 0; i < habitaciones.size(); i++){
                        Habitacion h = habitaciones.get(i);
                        System.out.println("HABITACION " + h.getCodHabitacion() + " Disponible: " + h.isDisponible() + ", Habilitado: " + h.isHabilitado());
                    }
                    break;
                    
                case "3":
                    admStats = false;
                    break;
                    
                default:
                    System.out.println("Favor ingrese una opcion valida");
            }
        }
    }
    
}
