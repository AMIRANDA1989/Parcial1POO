/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Nelson Flamenco
*/
public class Paquete {
    private int codPaquete;
    private String nombre;
    private String descripcion;
    private double preciopaquete;
    public ArrayList<Paquete> paquetes = new ArrayList();
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
    
    public void adminPaquetes(){
        String option;
        boolean admStats = true;
        
        while(admStats){
            System.out.println("");
            System.out.println("********ADMINISTRACION DE PAQUETES********");
            System.out.println("Seleccione la operacion que desea realizar:");
            System.out.println("1 - Modificar precio de paquetes");
            System.out.println("2 - Modificar servicios de paquetes");
            System.out.println("3 - Regresar");
            
            option = in.nextLine();
            
            switch (option){
                case "1":
                    for(int i = 0; i < paquetes.size(); i++){
                        Paquete p = paquetes.get(i);
                       
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
