/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.felix;

import java.time.LocalDate;
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
        ManejoMascota objMM = new ManejoMascota();
        Archivos objArch = new Archivos();
        CRUDCliente objCRUDC = new CRUDCliente();
        CRUDServicio objCRUDS = new CRUDServicio();
        CRUDMascota objCRUDM = new CRUDMascota();
        Cola c1,c2;
        ListaDoble li = new ListaDoble();
        Servicio objS = new Servicio();
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
                    id = Validaciones.leerString("Ingrese la cedula:");
                    objS = objF.asignarCita(id,"", li);
                    break;
                case 3:
                    //Cancelar cita
                    JOptionPane.showMessageDialog(null,"Funcion no disponible todavia.");
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
                    li = objMM.MascotasPorDueno(objArch, id);
                    menuMascotas(id,li,objF,objArch,objC);
                    break;
                case 2:
                    //Asignar cita
                    JOptionPane.showMessageDialog(null,"Funcion no disponible todavia.");
                    break;
                case 3:
                    //cancelar cita
                    JOptionPane.showMessageDialog(null,"Funcion no disponible todavia.");
                    break;
                case 4:
                    //editar informacion
                    JOptionPane.showMessageDialog(null,"Funcion no disponible todavia.");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,"Funcion no disponible todavia.");
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
        CRUDServicio objCRUDS = new CRUDServicio();
        CRUDMascota objCRUDM = new CRUDMascota();
        ManejoMascota objMM = new ManejoMascota();
        ManejoServicio objMS = new ManejoServicio();
        Mascota objM = new Mascota();
        
        Pila p , p2 = new Pila(100000);
        int op, tM = objMM.contarMascotas(li);
        
        do{
        op = Validaciones.leerEntero(objMM.mostrarImportanteLista(li)+"\n"+(tM+1)+
                ". Añadir Mascota."+"\n"+(tM+2)+". Atras.");
        }while(op>(tM+2));
        if(op == tM + 2) 
        {
            return;
        }else if(op<=tM)
        {
            objM = (Mascota) li.buscarIndice(op);
            //pila del Historial
            p = objMS.serviciosMascota(objArch, objM.getID());
            do{
                op = Validaciones.leerEntero(objF.mensajeMascota());
                switch(op)
                {
                    case 1:
                        JOptionPane.showMessageDialog(null,"Historia:\n" +
                                ((p.IsEmpty())?"No hay citas":objMS.ImprimirPila(p,p2 )));
                        break;
                    case 2: 
                        JOptionPane.showMessageDialog(null,"Cita:\n"+
                                objCRUDS.IngresarServicio(objArch,objM.getID()).toString());
                        break;
                    case 3:
                        LocalDate fecha = Validaciones.leerFecha(
                                "Ingrese la fecha de la cita para cancelar:").toLocalDate();
                        String idS = objMS.obtenerIDFecha(fecha,p,p2);
                        objCRUDS.cancelarCita(objArch, idS);
                        break;
                    case 4:
                        //editar
                        JOptionPane.showMessageDialog(null,"Funcion no disponible todavia.");
                        break;
                    case 5:
                        //eliminar mascota
                        JOptionPane.showMessageDialog(null,"Funcion no disponible todavia.");
                        break;
                    case 10:
                        JOptionPane.showMessageDialog(null,"Saliendo de Mascota.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Funcion no disponible.");
                        break;
                }
            }while(op<10);
        }else
        {
            //añadir mascota
            objCRUDM.IngresarMascota(objArch, id);
        }
        
                   
    }
    
    public Servicio asignarCita(String idDueno,String idMascota,ListaDoble li)
    {
        Archivos objArch = new Archivos();
        CRUDCliente objCRUDC = new CRUDCliente();
        CRUDServicio objCRUDS = new CRUDServicio();
        CRUDMascota objCRUDM =new CRUDMascota();
        ManejoMascota objMM = new ManejoMascota();
        ManejoServicio objMS = new ManejoServicio();
        
        Servicio objS = new Servicio();
        
        if(!objCRUDC.Buscar(objArch, idDueno)){
            objCRUDC.IngresarCliente(objArch, idDueno);
            idMascota = objCRUDM.IngresarMascota(objArch,idDueno).getID();
        }
        if(!idMascota.isBlank()){
            objS = objCRUDS.IngresarServicio(objArch, idMascota);
            return objS;
        }
        String nombre = Validaciones.leerString("Ingrese el nombre de la mascota");
        idMascota = objCRUDM.buscarNombre(objArch,idDueno,nombre);
        
        objS = objCRUDS.IngresarServicio(objArch,idMascota);
        
        return objS;
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
    private String mensajeCliente() {
        return """
              Menu Cliente:
              1.Mostrar Mascotas
              2.Asignar cita
              3.Cancelar cita
              4.Editar informacion
              5.
              10. Salir.
              """;
    }
    
    public String Opcion1()
    {
        return"""
              Menu Clinica:
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
