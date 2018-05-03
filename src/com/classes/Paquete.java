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
}
