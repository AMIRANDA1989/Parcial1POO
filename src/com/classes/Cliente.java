/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.classes;
/*
 * @author Nelson Flamenco
*/
public class Cliente {
    private int numCliente;
    private String nombre;
    private String apellido;
    private int dui;
    private int edad;
    private String sexo;
    private int telefono;
    private String email;
    private int numTarjeta;
    
    public Cliente(int numCliente,String nombre,String apellido,int dui,int edad, String sexo,int telefono,String email,int numTarjeta){
        this.numCliente=numCliente;
        this.nombre=nombre;
        this.apellido=apellido;
        this.dui=dui;
        this.edad=edad;
        this.sexo=sexo;
        this.telefono=telefono;
        this.email=email;
        this.numTarjeta=numTarjeta;
    }
    
    public Cliente(){}
    
    public int getNumCliente() {
        return numCliente;
    }
    
    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getDui() {
        return dui;
    }
    
    public void setDui(int dui) {
        this.dui = dui;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int getTelefono() {
        return telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getNumTarjeta() {
        return numTarjeta;
    }
    
    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
}
