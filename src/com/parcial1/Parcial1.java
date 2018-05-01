/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parcial1;

import com.classes.Engine;

/**
 *
 * @author allan
 */
public class Parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Engine sistema = new Engine();
        //Inicializando configuracion
        sistema.initSettings(6, 10);
        //Iniciando sistema
        sistema.initSystem();
    }
    
}
