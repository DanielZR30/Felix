/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.felix;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Felix {

    public static void main(String[] args) {
        
        int oppal;
        Felix objF = new Felix();
        
        do{//menu principal
            oppal=Validaciones.leerEntero(objF.menuPpal());
            switch(oppal)
            {
                case 1:
                    servicioClinico(objF);
                    break;
                case 2:
                    servicioTienda();
                    break;
                default:
                    break;
            }
            
        }while(oppal<3);
    }

    private static void servicioClinico(Felix objF) {
        int op;
        do{
            op = Validaciones.leerEntero(objF.Opcion1());
            switch(op)
            {
                case 1:
                    //ver citas para el dia
                    break;
                case 2:
                    //Asignar cita
                    break;
                case 3:
                    //Cancelar cita
                    break;
                case 4:
                    //Anadir cliente
                    break;
                case 5:
                    //Mostrar datos del cliente (menu cliente)
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no disponible.");
                    break;
            }
        }while(op<10);
    }

    private static void servicioTienda() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String menuPpal()
    {
        return"""
              Menu Principal:
              1.Clinica
              2.Tienda de Mascotas
              0.Salir
              """;
    }
    public String Opcion1()
    {
        return"""
              Menu Principal:
              1.Ver citas del dia.
              2.Asignar cita.
              3.Cancelar cita.
              4:Añadir cliente.
              5.Buscar cliente.
              10.Salir
              """;
    }

    public Felix() {
    }
    
    
}
