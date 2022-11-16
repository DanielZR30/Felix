/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.felix;

import java.time.LocalDateTime;
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
        ManejoServicio objMS = new ManejoServicio();
        Archivos objArch = new Archivos();
        Cola c1,c2;
        c1 = new Cola(100000);
        c2 = new Cola(100000);
        do{
            op = Validaciones.leerEntero(objF.Opcion1());
            switch(op)
            {
                case 1:
                    c1 = objMS.ArchivoDia(objArch, c1);
                    JOptionPane.showMessageDialog(null,"Citas para hoy:\n" +
                            objMS.ImprimirPorFecha(c1, c2));
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
              3.Salir
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
