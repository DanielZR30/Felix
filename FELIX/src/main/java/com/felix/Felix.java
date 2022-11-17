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
                    objF.servicioClinico(objF);
                    break;
                case 2:
                    objF.servicioTienda(objF);
                    break;
                default:
                    break;
            }
            
        }while(oppal<3);
    }

    private void servicioClinico(Felix objF) {
        int op;
        ManejoServicio objMS = new ManejoServicio();
        Archivos objArch = new Archivos();
        CRUDCliente objCRUDC = new CRUDCliente();
        CRUDServicio objCRUDS = new CRUDServicio();
        Cola c1,c2;
        String id;
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
                    id=Validaciones.leerString("Digite el documento del cliente: ");
                    objCRUDC.IngresarCliente(objArch, id);
                    break;
                case 5:
                    id=Validaciones.leerString("Digite el documento del cliente: ");
                    if(objCRUDC.Buscar(objArch, id))
                    {
                        objF.menuCliente(id,objF,objArch);
                    }else{
                        JOptionPane.showMessageDialog(null,"Cliente no encontrado.");
                    }
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null,"Abriendo menú principal");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no disponible.");
                    break;
            }
        }while(op<10);
    }

    public void servicioTienda(Felix objF) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void menuCliente(String id,Felix objF, Archivos objArch) {
        Cliente objC = new Cliente();
        CRUDCliente objCRUDC = new CRUDCliente();
        ManejoMascota objMM = new ManejoMascota();
        objC = objCRUDC.buscarID(objArch, id);
        Cola c1 = new Cola(100000),c2 = new Cola(100000);
        ListaDoble li = new ListaDoble();
        int op;
        do{
            op = Validaciones.leerEntero(objF.mensajeCliente());
            switch(op)
            {
                case 1:
                    //mostrar mascotas
                    li = objMM.MascotasPorDueno(objArch, li, id);
                    menuMascotas(id,li,objF,objArch,objC);
                    break;
                case 2:
                    //Asignar cita
                    break;
                case 3:
                    //cancelar cita
                    break;
                case 4:
                    //editar informacion
                    break;
                case 5:
                    
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null,"Abriendo menú Clinica");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no disponible.");
                    break;
            }
        }while(op<10);
        
    }
    
    private void menuMascotas(String id, ListaDoble li, Felix objF,
            Archivos objArch,Cliente objC) {
        CRUDCliente objCRUDC = new CRUDCliente();
        ManejoMascota objMM = new ManejoMascota();
        ManejoServicio objMS = new ManejoServicio();
        Mascota objM = new Mascota();
        
        Pila p , p2 = new Pila(100000);
        int op, tM = objMM.contarMascotas(li);
        
        do{
        op = Validaciones.leerEntero(li.InfoDesdeInicio()+"\n"+(tM+1)+
                ". Añadir Mascota."+"\n"+(tM+2)+". Atras.");
        }while(op>(tM+2));
        if(op == tM + 2) 
        {
            return;
        }else if(op<=tM)
        {
            objM = (Mascota) li.buscarIndice(op);
        }else
        {
            //añadir mascota
        }
        do{
            op = Validaciones.leerEntero(objF.mensajeMascota());
            switch(op)
            {
                case 1:
                    p = objMS.serviciosMascota(objArch, objM.getID());
                    JOptionPane.showMessageDialog(null,"Historia:\n" +
                            objMS.ImprimirPila(p,p2 ));
                    break;
                    
                    
            }
        }while(op<5);
        
        
        
                
    }
    
    public String menuPpal()
    {
        return"""
              Menu Principal:
              1.Mostrar Mascotas
              2.Asignar cita
              3.Cancelar cita
              4. Editar informacion
              5.
              """;
    }
    private String mensajeCliente() {
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
    private String mensajeMascota() {
        return"""
              Menu Mascota:
              1.Ver historial.
              2.Asignar cita.
              3.Cancelar cita.
              4.Editar informacion.
              5.Eliminar Mascota.
              10.Salir
              """;
    }

    public Felix() {
    }

    

    

    
    
    
}
