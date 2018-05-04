/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

import java.util.ArrayList;
import java.util.Scanner;

/*
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
        System.out.println("*****************BIENVENIDO***************");
        while (this.isStatus()){
            System.out.println("");
            System.out.println("");
            System.out.println("************HOTEL VIÑA RAFINHA************");
            System.out.println("Seleccione en el menú la opcion que desea:");
            System.out.println("1 - Control de Hotel"               );
            System.out.println("2 - Reservaciones"                  );
            System.out.println("3 - Gestor de Clientes"            );
            System.out.println("4 - Manejo de Ventas y Servicios"   );
            System.out.println("5 - Apagar Sistema..."              );
            
            System.out.println("opcion:");
            //obteniendo valor de operacion
            operation = in.nextLine(); 
            
            //validando valor de operacion
            switch (operation){
                case "1":
                    System.out.println("");
                    System.out.println("**************CONTROL DE HOTEL**************" );
                    this.controlHotel();
                    break;
                    
                case "2":
                    System.out.println("");
                    System.out.println("***************RESERVACIONES***************"  );
                    this.reservaHotel();
                    break;  
                    
                case "3":
                    System.out.println("");
                    System.out.println("*************GESTOR DE CLIENTES*************" );
                    this.clienteHotel();
                    break;
                    
                case "4":
                    System.out.println("");
                    System.out.println("********MANEJO DE VENTAS Y SERVICIOS********" );
                    this.adminHotel();
                    break;
                    
                case "5":
                    System.out.println("");
                    System.out.println("*********APAGANDO SISTEMA DE HOTEL*********"  );
                    System.out.println("Adios!"                                       );
                    this.setStatus(false);
                    break;
                    
                default: 
                    System.out.println("Favor ingrese una operacion valida..."        );
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
    agregarPiso
    Sirve para agregar un piso adicional al edificio
    */
    private void agregarPiso(){
        Piso p = new Piso();
        p.setCodPiso(Character.toString(Piso.letraPiso));
        this.pisosHotel.add(p);
        Piso.letraPiso++; //incrementando el codigo del piso para la proxima insercion
        System.out.println("Piso agregado exitosamente con codigo: " + p.getCodPiso());
        System.out.println("");
    }
    
    /*eliminarPiso
    Sirve para eliminar un piso del edificio.
    PARAMETROS
    codigoPiso: Codigo del piso a eliminar
    RETORNA
    1: Eliminacion exitosa
    0: Eliminacion fallida
    */
    private int eliminarPiso(String codPiso){
        int location = this.buscarPisoPorCodigo(codPiso);
        if(location > -1 ){
            this.pisosHotel.remove(location);
            return 1;
        }else{
            return 0;
        }
    }
    
    /*
    buscarPisoPorCodigo
    Sirve para buscar un piso por código
    retorna la ubicacion del piso que se quiere buscar
    retorna -1 si no se encuentra nada en el ArrayList
    */
    
    private int buscarPisoPorCodigo(String codigo){
        int pisoLocation = -1;
        //-1 es un valor por defecto, indica que no se encontró el piso solicitado
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
    
    private void controlHotel(){
        String option;
        String pisoOpt;
        boolean controlHotelStats = true;
        int location;
        
        while (controlHotelStats){
            System.out.println("Seleccione la operacion que desea realizar:");
            System.out.println("1 - Revisar estado de pisos."            );
            System.out.println("2 - Administrador de habitaciones."     );
            System.out.println("3 - Habilitar/Deshabilitar pisos"        );
            System.out.println("4 - Agregar Piso"        );
            System.out.println("5 - Eliminar Piso"        );
            System.out.println("6 - Regresar..."                         );
            
            System.out.println("opcion:");
            
            option = in.nextLine();
            
            switch (option) {
                case "1":
                    System.out.println("*************Revisar estado de pisos*************"     );
                    //System.out.println(pisosHotel.size());
                    for(int i = 0; i < pisosHotel.size(); i++){
                        Piso p = pisosHotel.get(i);
                        String habilitado = p.isHabilitado()? "Habilitado" : "Deshabilitado";
                        System.out.println("[Piso " + p.getCodPiso() + "] Estado: " + habilitado + ", Numero Habitaciones: " + p.getHabitaciones().size());
                    }
                    System.out.println("");
                    break;
                    
                case "2":
                    System.out.println("**********Administrador de pisos**********"     );
                    System.out.println("Ingrese el codigo del piso: ");
                    pisoOpt = in.nextLine();
                                   
                    location = this.buscarPisoPorCodigo(pisoOpt);
                    
                    //validando si el piso ingresado existe
                    if(location > -1){
                        Piso p = pisosHotel.get(location);
                        p.adminHabitaciones();
                    }else{
                        System.out.println("No se ha encontrado el piso ingresado");
                    }
                    break;
                    
                case "3":
                    System.out.println("**********Habilitar/Deshabilitar pisos**********"      );
                    System.out.println("Ingrese el codigo del piso: ");
                    pisoOpt = in.nextLine();
                                   
                    location = this.buscarPisoPorCodigo(pisoOpt);
                    
                    //validando si el piso ingresado existe
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
                            System.out.println("Estado de piso modificado...");
                        }
                    }else{
                        System.out.println("No se ha encontrado el piso ingresado");
                    }
                    break;
                
                case "4":
                    System.out.println("**********Agregar Piso**********"      );
                    System.out.println("Esta por agregar un piso adicional al hotel, presione Y para continuar");
                    if(in.nextLine().equals("Y")){
                        this.agregarPiso();
                    }
                    break;
                    
                case "5":
                    System.out.println("**********Eliminar Piso**********"      );
                    System.out.println("Ingrese el codigo del piso: ");
                    pisoOpt = in.nextLine();
                                   
                    location = this.buscarPisoPorCodigo(pisoOpt);
                    
                    //validando si el piso ingresado existe
                    if(location > -1){
                        String cod = this.pisosHotel.get(location).getCodPiso();
                        System.out.println("El piso seleccionado sera eliminado, presione Y para confirmar");
                        if(in.nextLine().equals("Y")){
                            
                            if( this.eliminarPiso(cod) == 1 ){
                                System.out.println("Piso Eliminado con exito");
                            }else{
                                System.out.println("Ha ocurrido un problema al eliminar el piso");
                            }
                        }
                    }else{
                        System.out.println("No se ha encontrado el piso ingresado");
                    }
                    break;
                    
                case "6":
                    controlHotelStats = false;
                    break;
                    
                default:
                    System.out.println("Favor ingrese una opcion valida");
                    break;
            }//fin swicth(controlHotelStats)
        }//fin while (controlHotelStats)
    }  
    
    private void reservaHotel(){
        String option;
        boolean reservaHotelStats = true;
        
        while (reservaHotelStats){
            System.out.println("Seleccione la operacion que desea realizar:"    );
            System.out.println("1 - Realizar reservación"                       );
            System.out.println("2 - Modificar reservación"                      );
            System.out.println("3 - Cancelar reservación"                       );
            System.out.println("4 - Regresar..."                                );
            
            System.out.println("opcion:");
            
            option = in.nextLine();
            
            switch (option) {
                case "1":
                    System.out.println("**********Realizar reservacion**********"  );
                    this.inputCliente();
                    System.out.println(""  );
                    System.out.println("**********Seleccionando Habitación del Cliente**********"   );
                    System.out.println("Clase de habitacion a hospedarse:"         );
                    System.out.println("  1.Sencilla         2.Doble  "            );
                    
              
                    
                    
                    
                    
                    
                    System.out.println("Paquete de Habitacion:");
                    System.out.println("  1.Agregar           2.Omitir"            );
                   
                    System.out.println("Seleccion de Paquete:");
                    System.out.println("  1.Basico           2.Premium"            );
                    
                    System.out.println("Dias de hospedaje:");
                    
                    System.out.println("Precio por dia de hospedaje:");
                    
                    System.out.println("Costo total:");
                    break;
                    
                case "2":
                    System.out.println("**********Modificar reservacion**********" );
                    break;
                    
                case "3":
                    System.out.println("**********Cancelar reservacion**********"  );
                    break;
                    
                case "4":
                    reservaHotelStats = false;
                    break;
                    
                default:
                    System.out.println("Favor ingrese una opcion valida");
                    break;
            }//fin swicth(reservaHotelStats)
        }//fin while (reservaHotelStats)
    }  
//***********************************************************************************************************************************
    private void clienteHotel(){
        String option;
        boolean clienteHotelStats = true;
        
        System.out.println("Seleccione la operacion que desea hacer:");
        System.out.println("1 - Agregar cliente "                 );
        System.out.println("2 - Modificar cliente"                );
        System.out.println("3 - Eliminar cliente "                );
        System.out.println("4 - Regresar..."                      );
            
        System.out.println("opcion:");        
        
        while (clienteHotelStats){
            System.out.println("");
            
            option = in.nextLine();
            
            switch (option) {
                case "1":
                    System.out.println("***********Agregar cliente***********");
                    this.inputCliente();
                    break;
                    
                case "2":
                    System.out.println("**********Modificar cliente**********");
                    this.modCliente();
                    break;   
                    
                case "3":
                    System.out.println("***********Eliminar cliente**********");
                    this.deleteCliente();
                    break;   
                    
                case "4":
                    clienteHotelStats = false;
                    break;
                    
                default:
                    System.out.println("Favor ingrese una opcion valida"      );
                    break;
            }//fin swicth(clienteHotelStats)
        }//fin while (clienteStats)
    } 
    
        private void inputCliente(){
        ArrayList<Cliente> c = new ArrayList<>();
        
        String nombre,apellido,sexo,email;
        int idCliente=0,edad=0,telefono=0,dui=0,numTarjeta=0;
        
        System.out.println("");
        System.out.println("Ingresando datos personales...");
        System.out.println("Ingrese nombre:");
        nombre=in.nextLine();
        System.out.println("Ingrese apellido:");
        apellido=in.nextLine();
        System.out.println("Ingrese dui:");
        dui=in.nextInt();
        System.out.println("Ingrese edad:");
        edad=in.nextInt();
        sexo=in.nextLine();
        System.out.println("Ingrese sexo:");
        sexo=in.nextLine();
        System.out.println("Ingrese telefono:");
        telefono=in.nextInt();
        sexo=in.nextLine();
        System.out.println("Ingrese e-mail:");
        email=in.nextLine();
        System.out.println("Ingrese numero tarjeta:");
        numTarjeta=in.nextInt();
        in.nextLine();
        System.out.println("Datos ingresados exitosamente...");
        System.out.println("");
        
        Cliente cliente=new Cliente(nombre,apellido,dui,edad,sexo,telefono,email,numTarjeta);
        c.add(cliente);
    } 
        
    private void modCliente(){}
    
    private void deleteCliente(){}

//***************************************************************************************************************************************************
    private void adminHotel(){
        String option;
        boolean adminHotelStats = true;
        
        System.out.println("Seleccione la operacion que desea hacer:");
        System.out.println("1 - Gestion de Costos "                 );
        System.out.println("2 - Administracion de Servicios"         );
        System.out.println("3 - Regresar..."                         );
            
        System.out.println("opcion:"); 
        
        while(adminHotelStats){
            System.out.println("");

            option = in.nextLine();
            
            switch (option) {
                case "1":
                    System.out.println("***********Gestion de Costos***********");
                    System.out.println("Modificar precio a:"                   );
                    System.out.println("  1.Habitacion   2.Piso   3.Paquete       ");
                    
                    System.out.println("opcion:"); 
                    option = in.nextLine();
                    
                    switch (option) {
                        case "1":
                            System.out.println("**************Precio de Habitacion**************" );
                            
                            break;
                            
                        case "2":
                            System.out.println("****************Precio por Piso****************");
                            
                            break;
                            
                        case "3":
                            System.out.println("**************Precio de Paquetes**************" );
                            
                            break;     
                    }
                    break;
                    
                case "2":
                    System.out.println("******Administracion de Servicios*******"               );               
                    System.out.println("Seleccion de Paquete:");
                    System.out.println("    1.Basico    2.Premium   3.Personalizado"            );
                    
                    System.out.println("opcion:"); 
                    option = in.nextLine();
                    
                    switch (option) {
                        case "1":
                            this.BasicoPaquete();
                            break;
                            
                        case "2":
                            this.PremiumPaquete();
                            break;
                        
                        case "3":
                            this.PersonalizadoPaquete();
                            break;
                    }
                    break;  
                    
                case "3":
                    adminHotelStats = false;
                    break;
                    
                default:
                    System.out.println("Favor ingrese una opcion valida");
                    break;
            }//fin swicth(adminHotelStats)
        }//fin while (adminHotelStats)
    } 
    
//Paquetes
    
    public void PremiumPaquete(){
        String option;
        boolean admStats = true;
        while(admStats){
            System.out.println("");
            System.out.println("**************PAQUETE PREMIUM**************");
            System.out.println("Seleccione la operacion que desea realizar:");
            System.out.println("1 - Agregar servicio");
            System.out.println("2 - Modificar servicio");
            System.out.println("3 - Eliminar servicio");
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
                    System.out.println("Acceso a la piscina");
                    System.out.println("Acceso al buffet desayuno"               );
                    System.out.println("Acceso al minibar"                       );
                    break;
                    
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
            System.out.println("1 - Agregar servicio");
            System.out.println("2 - Modificar servicio");
            System.out.println("3 - Eliminar servicio");
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
            System.out.println("1 - Agregar servicio");
            System.out.println("2 - Modificar servicio");
            System.out.println("3 - Eliminar servicio");
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
