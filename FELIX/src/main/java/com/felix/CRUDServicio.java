/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CRUDServicio {
    DateTimeFormatter formato =DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    /**
     * Ingresa un servicio
     * @param objArch
     * @param ID id de la mascota
     */
    public Servicio IngresarServicio(Archivos objArch,String ID) 
    {
        Servicio objs = new Servicio();
        //se invoca el metodo buscar   
        //se llama el metodo de ingresar datos recibe IDaca y retorna el objeto vehiculo  
        objs = objs.ingresar(ID);//se invoca el metodo que graba fisicamente en el archivo
        JOptionPane.showMessageDialog(null, objs);
        GrabarServicio(objArch,objs);
        return objs;
    }//fin de ingresar
    
   //metodo que graba fisicamente el registro en el archivo
     public void GrabarServicio(Archivos objArchivos, Servicio objs) 
    {
        try {
            String cadena = "";
            objArchivos.AbrirArchivoModoEscritura("Servicio.txt");
            /*con el objeto vehiculo que llega se invoca el metodo para la estructura del registro
            separado por comas y se recibe en la local cadena para grabarla en el archivo*/
            cadena = objs.estructuraReg();
            //la cadena separada por comas se graba persistentemente en memoria
            objArchivos.EscribirRegistro("" + cadena);
            objArchivos.CerrarArchivoModoEscritura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "*****SE GRABA EN El ARCHIVO DE VEHICULOS*****");
        }
    }
    
    
    public int contarServicioMascota(Archivos objArch, String idm)
    {
        int cont = 0;
        CRUDMascota objc = new CRUDMascota();
        
        try {
            
            if(objc.Buscar(objArch, idm)){
                //locales auxiliares para extraer la informacion del archivo
                String IDM;

                String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
                //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
                JOptionPane.showMessageDialog(null,""+objArch.AbrirArchivoModoLectura("Servicio.txt"));
                //se invoca al metodo de leer registro con 11 atributos para el vector de la linea o registro del archivo IDano 
                //se recibe el texto en Reg
                Reg = objArch.LeerRegistro(8);
                //mientras existan datos en el archivo
                while (Reg[0]!= null) //mientras not EOF()
                {
                    /*los datos del Reg que se obtiene del archivo IDano de texto se 
                    asignan a las variables auxiliares locales para su facil manejo 
                    como posiciones del vector String*/
                    IDM = Reg[1];   

                    //si la ID que estamos buscando es igual a la ID que extraimos del archivo en Reg
                    if(idm.equalsIgnoreCase(IDM))
                    {cont++;}//fin si
                    //se lee el otro registro para que termine secuencialmente la lectura del archivo texto
                    Reg = objArch.LeerRegistro(8);
                }//fin mientras
                //cerramos el archivo IDano de texto en modo lectura
                objArch.CerrarArchivoModoLectura();
            }else{
                JOptionPane.showMessageDialog(null,"Mascota no encontrado.");
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }        
        return cont;
    }
    /**
     * actualiza el cancelado a true
     * @param objArch
     * @param idS 
     */
    public void cancelarCita(Archivos objArch,String idS)
    {
       try {
            String id,ti,idM,obs;
            LocalDateTime fe;
            double pr;
            boolean can,as;
            
            String Reg[];
            JOptionPane.showMessageDialog(null,""+objArch.AbrirArchivoModoEscritura("Servicio.txt"));
            Reg = objArch.LeerRegistro(8);
            
            while(Reg != null)
            {
                id = Reg[0];
                idM = Reg[1];
                ti = Reg[2];
                obs = Reg[3];
                fe = LocalDateTime.parse(Reg[4],formato);
                pr = Double.parseDouble(Reg[5]);
                can = Reg[6].equalsIgnoreCase("true");
                as = Reg[7].equalsIgnoreCase("true");
            
                Servicio s = new Servicio(id,idM,ti,obs,fe,pr,can,as);
                
                if(id.equalsIgnoreCase(idS)&&!as)
                {
                    s.setCancelado(true);
                    JOptionPane.showMessageDialog(null,"Cita cancelada");
                }else{
                    JOptionPane.showMessageDialog(null,"No se puede cancelar.");
                }
                Reg = objArch.LeerRegistro(8);
            }
            objArch.CerrarArchivoModoEscritura();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        
    }
    
}
