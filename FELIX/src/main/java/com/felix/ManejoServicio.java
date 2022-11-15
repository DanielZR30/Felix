/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ManejoServicio {
    
    public Cola ArchivoDia(Archivos objArch,Cola c1,Cola c2)
    {
        try{
            String id,ti,idm,obs;
            LocalDate fe;
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
                fe = LocalDate.parse(Reg[4]);
                pr = Double.parseDouble(Reg[5]);
                can = Reg[6].equalsIgnoreCase("true");
                as = Reg[6].equalsIgnoreCase("true");
            }
            
        }catch(Exception ex){
            
        }
        return c1;
    }
    
}
