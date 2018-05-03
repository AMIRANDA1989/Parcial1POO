/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

import java.util.Scanner;

/*
 * @author Nelson Flamenco
*/
public class Paquete {
    private int codPaquete;
    private String nombre;
    private String descripcion;
    private double preciopaquete;
    Scanner in = new Scanner(System.in); //Sirve para leer el input del usuario
    
    public Paquete(int codPaquete,String nombre,String descripcion,double preciopaquete){
        this.codPaquete=codPaquete;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.preciopaquete=preciopaquete;
    }
            
    public Paquete(){}
    
    public int getCodPaquete() {
        return codPaquete;
    }
    
    public void setCodPaquete(int codPaquete) {
        this.codPaquete = codPaquete;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getPreciopaquete() {
        return preciopaquete;
    }
    
    public void setPrecio(double preciopaquete) {
        this.preciopaquete = preciopaquete;
    }
    
//Paquetes
    
    public void PremiumPaquete(){
        String option;
        boolean admStats = true;
        while(admStats){
            System.out.println("");
            System.out.println("**************PAQUETE PREMIUM**************");
            System.out.println("Seleccione la operacion que desea realizar:");
            System.out.println("1 - Agregar servicio de Paquetes");
            System.out.println("2 - Modificar servicio de Paquete");
            System.out.println("3 - Eliminar servicio de Paquete");
            System.out.println("4 - Regresar");
            
            option = in.nextLine();
            
            switch (option){
                case "1":
                    System.out.println("*******Agregar servicio de Paquetes*******");
                    
                    break;
                    
                case "2":
                    System.out.println("************Modificar Servicios************");
                    
                    System.out.println("Internet Ilimitado"                      );
                    System.out.println("Servicio a la Habitacion"                );
                    System.out.println("Acceso a la piscina"                     );
                    System.out.println("Acceso al buffet desayuno"               );
                    System.out.println("Acceso al minibar"                       );
                    
                case "3":
                    System.out.println("*******Eliminar servicio de Paquetes*******");
                    
                    break; 
                    
                case "4":
                    admStats = false;
                    break;
                    
                default:
                    System.out.println("Favor ingrese una opcion valida");
            }
        }
    }
    
    public void BasicoPaquete(){
        String option;
        boolean admStats = true;
        
        while(admStats){
            System.out.println("");
            System.out.println("**************PAQUETE BASICO**************");
            System.out.println("Seleccione la operacion que desea realizar:");
            System.out.println("1 - Agregar servicio de Paquetes");
            System.out.println("2 - Modificar servicio de Paquete");
            System.out.println("3 - Eliminar servicio de Paquete");
            System.out.println("4 - Regresar");
            
            option = in.nextLine();
            
            switch (option){
                case "1":
                    System.out.println("*******Agregar servicio de Paquetes*******");
                    
                    break;
                    
                case "2":
                    System.out.println("************Modificar Servicios************");
                    
                    System.out.println("Internet Ilimitado"                      );
                    System.out.println("Acceso a la piscina"                     );
                
                case "3":
                    System.out.println("*******Eliminar servicio de Paquetes*******");
                    
                    break; 
                    
                case "4":
                    admStats = false;
                    break;
                    
                default:
                    System.out.println("Favor ingrese una opcion valida");
            }
        }
    }
    
    public void PersonalizadoPaquete(){
        String option;
        boolean admStats = true;
        
        while(admStats){
            System.out.println("");
            System.out.println("************PAQUETE PERSONALIZADO************");
            System.out.println("Seleccione la operacion que desea realizar:");
            System.out.println("1 - Agregar servicio de Paquetes");
            System.out.println("2 - Modificar servicio de Paquete");
            System.out.println("3 - Eliminar servicio de Paquete");
            System.out.println("4 - Regresar");
            
            option = in.nextLine();
            
            switch (option){
                case "1":
                    System.out.println("*******Agregar servicio de Paquetes*******");
                    
                    break;
                    
                case "2":
                    System.out.println("************Modificar Servicios************");
                    
//                    System.out.println("Internet Ilimitado"                      );
//                    System.out.println("Servicio a la Habitacion"                );
//                    System.out.println("Acceso a la piscina"                     );
//                    System.out.println("Acceso al buffet desayuno"               );
//                    System.out.println("Acceso al minibar"                       );
//algunos de estos                
                case "3":
                    System.out.println("*******Eliminar servicio de Paquetes*******");
                    
                    break; 
                    
                case "4":
                    admStats = false;
                    break;
                    
                default:
                    System.out.println("Favor ingrese una opcion valida");
            }
        }
    }    
}
