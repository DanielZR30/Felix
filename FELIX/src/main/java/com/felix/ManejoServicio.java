/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ManejoServicio {
    
    //formato para fechas
    DateTimeFormatter formato =DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public Cola ArchivoDia(Archivos objArch,Cola c1)
    {
        try{
            String id,ti,idm,obs;
            LocalDateTime fe;
            double pr;
            boolean can,as;
            
            String Reg[];
            JOptionPane.showMessageDialog(null,""+objArch.AbrirArchivoModoLectura("Servicio.txt"));
            Reg = objArch.LeerRegistro(8);
            
            while(Reg != null)
            {
                id = Reg[0];
                idm = Reg[1];
                ti = Reg[2];
                obs = Reg[3];
                fe = LocalDateTime.parse(Reg[4],formato);
                pr = Double.parseDouble(Reg[5]);
                can = Reg[6].equalsIgnoreCase("true");
                as = Reg[6].equalsIgnoreCase("true");
            
                Servicio s = new Servicio(id,idm,ti,obs,fe,pr,can,as);
                
                if(fe.toLocalDate().equals(LocalDateTime.now().toLocalDate()))
                {
                    c1.Push(s);
                }
                Reg = objArch.LeerRegistro(8);
            }
            objArch.CerrarArchivoModoLectura();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return c1;
    }
    
    public Pila serviciosMascota(Archivos objArch,String idm)
    {
        CRUDMascota objc = new CRUDMascota();
        ListaDoble li = new ListaDoble();
        Pila p1 = new Pila(100000);
        try {
            String id,ti,idM,obs;
            LocalDateTime fe;
            double pr;
            boolean can,as;
            
            String Reg[];
            JOptionPane.showMessageDialog(null,""+objArch.AbrirArchivoModoLectura("Servicio.txt"));
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
            
                Servicio s = new Servicio(id,idm,ti,obs,fe,pr,can,as);
                
                if(idm.equalsIgnoreCase(idM))
                {
                    p1.Push(s);
                }
                Reg = objArch.LeerRegistro(8);
            }
            objArch.CerrarArchivoModoLectura();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return p1;
    }
    
    public String ImprimirPila(Pila p1, Pila p2)
    {
        String cadena=""; 
        Servicio s;
        while(p1.IsEmpty()==false)
        {
          s=(Servicio) p1.Pop();//desacolamos el cliente en la cola original
          cadena= cadena+"Servicio:"+s.imprimirImportante();//se coloca en la cadena para mandar a imprimir
          p2.Push(s);//se acola en la cola auxiliar para que no se pierda la informacion
        }//fin de mientras
        PasarPila(p2,p1);//llamada al metodo para volver los datos de auxiliar a original
        return cadena;
    }
    
    public String ImprimirPorFecha(Cola c1, Cola c2)
    {
        String cadena=""; 
        Servicio s;
        while(c1.IsEmpty()==false)
        {
          s=(Servicio) c1.Pop();//desacolamos el cliente en la cola original
          cadena= cadena+"Servicio:"+s.imprimirImportante();//se coloca en la cadena para mandar a imprimir
          c2.Push(s);//se acola en la cola auxiliar para que no se pierda la informacion
        }//fin de mientras
        PasarCola(c2,c1);//llamada al metodo para volver los datos de auxiliar a original
        return cadena;
    }
    
    public void PasarCola(Cola objca,Cola objc)
    {
        while(objca.IsEmpty()==false)
        {
            objc.Push(objca.Pop());
        }//fin mientras
    }//fin de deolver cola
    
    public void PasarPila(Pila objpa,Pila objp)
    {
        while(objpa.IsEmpty()==false)
        {
            objp.Push(objpa.Pop());
        }//fin mientras
    }//fin de deolver cola
}
