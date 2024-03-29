/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ManejoMascota {
    
    public ListaDoble MascotasPorDueno(Archivos objArch,String idDueno)
    {
        ListaDoble li = new ListaDoble();
        try{
            String id,nom,esp,duen,gen;
            
            String Reg[];
            JOptionPane.showMessageDialog(null,""+objArch.AbrirArchivoModoLectura("Mascota.txt"));
            Reg = objArch.LeerRegistro(5);
            
            while(Reg[0] != null)
            {
                id = Reg[0];
                nom = Reg[1];
                esp = Reg[2];
                duen = Reg[3];
                gen = Reg[4];
                
                Mascota m = new Mascota(id,nom,esp,duen,gen);
                
                if(idDueno.equalsIgnoreCase(duen))
                {
                    li.InsertarNodoPorInicio(m);
                }
                Reg = objArch.LeerRegistro(8);
            }
            objArch.CerrarArchivoModoLectura();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return li;
    }

    public String mostrarImportanteLista(ListaDoble li){
        Mascota dato;
        int cont = 0;
        String txt = "";
        li.q = li.getStart();
        while(li.q!=null){
            cont ++;
            dato = (Mascota) li.q.getDato();
            txt += cont+". " + dato.getID() + "," + dato.getNombre() +
                    dato.getEspecie()+ "\n";
            li.q = li.q.getSig();
        }
        return txt;
    }
    
    public int contarMascotas(ListaDoble li)
    {
        int cont = 0;
        
        li.q = li.getStart();
        
        while(li.q != null)
        {
            li.q = li.q.getSig();
            cont ++;
        }
        
        return cont;
    }

    
}
