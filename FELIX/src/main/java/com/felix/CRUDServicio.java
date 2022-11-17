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
public class CRUDServicio {
    
    
    
    
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
                while (Reg != null) //mientras not EOF()
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
    
}
