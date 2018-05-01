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
 * la clase Engine es el motor principal de la aplicacion, se inicializa desde el main para poder correr
 * el sistema y la solucion
 */
public class Engine {
    private boolean status = false; //Bandera que indica si el programa se ha inicializado su default es falso y se tiene que poner a true para que ejecute
    private String operation; //Tipo de operacion realizada
    private ArrayList<Piso> pisosHotel = new ArrayList(); //Pisos del Hotel
    Scanner in = new Scanner(System.in); //Sirve para leer el input del usuario

    /*
    * initSystem inicializa el sistema, es necesario ejecutarlo despues de la declaracion de un objeto de Clase Engine.
    */
    public void initSystem(){
        this.setStatus(true);
        
        while (this.isStatus()){
            System.out.println("*****HOTEL VIÑA RAFINHA*****");
            System.out.println("**********BIENVENIDO********");
            System.out.println("Seleccione la operacion que desea hacer:");
            System.out.println("1 - Administracion del hotel.");
            System.out.println("2 - Administracion de clientes.");
            System.out.println("3 - Administracion de reservaciones");
            System.out.println("4 - Administracion de ventas");
            System.out.println("5 - Cerrar sistema.");
            
            //obteniendo valor de operacion
            operation = in.nextLine(); 
            
            //validando valor de operacion
            switch (operation){
                case "1":
                    System.out.println("INGRESANDO A MODULO DE ADMINISTRACION DE HOTEL");
                    this.adminHotel();
                    break;
                
                case "5":
                    System.out.println("Adios!");
                    this.setStatus(false);
                    break;
                    
                default: 
                    System.out.println("Favor ingrese una operacion valida");
                    break;
            }
            
        }
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    /*
    InitSettings
    Sirve para inicializar las variables necesarias para el hotel, es decir, pisos y habitaciones
    PARAMETROS:
    pisos: cantidad de pisos que tendrá el hotel; 
    habitaciones: Cantidad de pisos por habitacion;
    */
    public void initSettings(int pisos, int habitaciones){
        ArrayList<Habitacion> rooms;
        System.out.println("Inicializando configuracion de pisos");
        System.out.println(Character.toChars('A'+pisos));
        //creando el piso
        for (char alphabet = 'A'; alphabet <= 'A'+pisos; alphabet++) {
            System.out.println(Character.toString(alphabet));
            rooms = new ArrayList();
            Piso newpiso = new Piso();
            newpiso.setCodPiso(Character.toString(alphabet));
           
            //agregando las habitaciones del piso, segun fue indicado en el parametro de habitaciones
            for (int j = 1; j == habitaciones; j++){
                Habitacion hab = new Habitacion();
                
                //validando si es numero par
                if (j%2 == 0){
                    hab.setCapacidad(2);
                }
                else{
                    hab.setCapacidad(1);                                 
                }
                
                hab.setCodHabitacion(Character.toString(alphabet)+Integer.toString(j));
                hab.setDisponible(true);
                hab.setHabilitado(true);
                newpiso.habitaciones.add(hab);
                
            }//fin for (int j = 1; j == habitaciones; j++)
            
            newpiso.setHabilitado(true);
            this.pisosHotel.add(newpiso);

        } // fin for (char alphabet = 'A'; alphabet <= (char)pisos; alphabet++)
    }
    
    /*
    buscarPisoPorCodigo
    Sirve para buscar un piso por código
    retorna la ubicacion del piso que se quiere buscar
    retorna -1 si no se encuentra nada en el ArrayList
    */
    private int buscarPisoPorCodigo(String codigo){
        int pisoLocation = -1; //-1 es un valor por defecto, indica que no se encontró el piso solicitado
        //buscando a traves del arraylist el codigo del piso
        for(int i = 0; i < pisosHotel.size(); i++){
            Piso p = pisosHotel.get(i);
            String codPiso = p.getCodPiso();

            if(codPiso.equals(codigo)){
                pisoLocation = i;
            }
        }
        
        return pisoLocation;
    }
    
    /*
    AdminHotel
    Sirve para administrar los pisos y las habitaciones
    es privado ya que solo la clase Engine debe accederla
    de lo contrario funcionaría de manera incompleta
    */
    private void adminHotel(){
        String option;
        String pisoOpt;
        boolean admHotelStats = true;
        
        while (admHotelStats){
            System.out.println("");
            System.out.println("");
            System.out.println("*****HOTEL VIÑA RAFINHA*****");
            System.out.println("**ADMINISTRACION DEL HOTEL**");
            System.out.println("Seleccione la operacion que desea hacer:");
            System.out.println("1 - Revisar estado de pisos.");
            System.out.println("2 - Administracion de habitaciones.");
            System.out.println("3 - Habilitar/desabilitar pisos");
            System.out.println("4 - Regresar");
            
            option = in.nextLine();
            
            switch (option) {
                case "1":
                    //System.out.println(pisosHotel.size());
                    for(int i = 0; i < pisosHotel.size(); i++){
                        Piso p = pisosHotel.get(i);
                        System.out.println("PISO " + p.getCodPiso() + ": " + p.isHabilitado());
                    }
                    break;
                case "2":
                    System.out.println("Ingrese el codigo del piso: ");
                    pisoOpt = in.nextLine();
                                   
                    int pisoLocation = this.buscarPisoPorCodigo(pisoOpt);
                    
                    //validando si el piso inresado existe
                    if(pisoLocation > -1){
                        Piso p = pisosHotel.get(pisoLocation);
                        p.adminHabitaciones();
                    }else{
                        System.out.println("No se ha encontrado el piso ingresado");
                    }
                    
                    break;
                    
                case "3":
                    System.out.println("Ingrese el codigo del piso: ");
                    pisoOpt = in.nextLine();
                                   
                    int location = this.buscarPisoPorCodigo(pisoOpt);
                    
                    //validando si el piso inresado existe
                    if(location > -1){
                        Piso p = pisosHotel.get(location);
                        System.out.println("El estado actual del piso es : " + p.isHabilitado() + " , Desea cambiarlo?" );
                        System.out.println("Presione Y para aceptar, N o cualquier otra tecla para cancelar");
                        if(in.nextLine().equals("Y")){
                            p.setHabilitado(!(p.isHabilitado()));
                            //Se elimina el piso para hacer la actualizacion
                            pisosHotel.remove(location);
                            //se agrega el nuevo piso para hacer la actualizacion
                            pisosHotel.add(location,p);
                        }
                    }else{
                        System.out.println("No se ha encontrado el piso ingresado");
                    }
                    
                case "4":
                    admHotelStats = false;
                    break;
                default:
                    System.out.println("Favor ingrese una opcion valida");
                    break;
            }
            
        }//fin while (admHotelStats)

    }
    
    
    
}
