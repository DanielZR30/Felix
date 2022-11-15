/*
 * Click nbfs://nbhost/SystemFileSystem/TemIDates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/TemIDates/Classes/Class.java to edit this temIDate
 */
package com.felix;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CRUDMascota {
    /*Metodo que busca una ID en el archivo y si lo encuentra
    retorna verdadero, sino lo encuentra retorna falso*/
     public boolean Buscar(Archivos objArch, String ID) 
    { 
        boolean sw=false;
        try {
            //locales auxiliares para extraer la informacion del archivo
            String IDM,nombre,especie,dueno,genero;
             
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null,""+objArch.AbrirArchivoModoLectura("Mascota.txt"));
            //se invoca al metodo de leer registro con 11 atributos para el vector de la linea o registro del archivo IDano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(5);
            //mientras existan datos en el archivo
            while (Reg != null) //mientras not EOF()
            {
                /*los datos del Reg que se obtiene del archivo IDano de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                IDM = Reg[0];
                nombre = Reg[1];
                especie= Reg[2];
                dueno = Reg[3];
                genero = Reg[4];       
                
                //si la ID que estamos buscando es igual a la ID que extraimos del archivo en Reg
                if(ID.equalsIgnoreCase(IDM))
                {sw=true;}//fin si
                //se lee el otro registro para que termine secuencialmente la lectura del archivo texto
                Reg = objArch.LeerRegistro(5);
            }//fin mientras
            //cerramos el archivo IDano de texto en modo lectura
            objArch.CerrarArchivoModoLectura();

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }
       return sw;
       
    }//fin de buscar
     
      //--------------------------------------------------------------    
     /*metodo que a partir de una IDaca del vehiculo la busca en el archivo y si no lo encuentra
     lo graba fisicamente con sus otros datos en el archivo y si lo encuentra muestra un mensaje 
     y no graba de nuevo al emIDeado porque estaría repetido*/ 
     public void IngresarMascota(Archivos objArch,String ID) 
    {
       Mascota objm = new Mascota();
        //se invoca el metodo buscar   
        if(Buscar(objArch,ID)==false)
                { 
                  //se llama el metodo de ingresar datos recibe IDaca y retorna el objeto vehiculo  
                  objm = objm.ingresarDatos(ID);
                  //se invoca el metodo que graba fisicamente en el archivo
		  GrabarMascota(objArch,objm); 
                }
                else
                {
                	JOptionPane.showMessageDialog(null, "*****El vehiculo YA existe en el archivo*****");
                }
        
    }//fin de ingresar 
   //metodo que graba fisicamente el registro en el archivo
     public void GrabarMascota(Archivos objArchivos, Mascota objm) 
    {
        try {
            String cadena = "";
            objArchivos.AbrirArchivoModoEscritura("Mascota.txt");
            /*con el objeto vehiculo que llega se invoca el metodo para la estructura del registro
            separado por comas y se recibe en la local cadena para grabarla en el archivo*/
            cadena = objm.estructuraReg();
            //la cadena separada por comas se graba persistentemente en memoria
            objArchivos.EscribirRegistro("" + cadena);
            objArchivos.CerrarArchivoModoEscritura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "*****SE GRABA EN El ARCHIVO DE VEHICULOS*****");
        }
    }//fin de grabar 
     
     //cuenta cuantas mascotas tiene un cliente
    public int contarMascotasDueno(Archivos objArch, String idd)
    {
        int cont = 0;
        CRUDCliente objc = new CRUDCliente();
        
        try {
            
            if(objc.Buscar(objArch, idd)){
                //locales auxiliares para extraer la informacion del archivo
                String IDM,nombre,especie,dueno,genero;

                String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
                //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
                JOptionPane.showMessageDialog(null,""+objArch.AbrirArchivoModoLectura("Mascota.txt"));
                //se invoca al metodo de leer registro con 11 atributos para el vector de la linea o registro del archivo IDano 
                //se recibe el texto en Reg
                Reg = objArch.LeerRegistro(5);
                //mientras existan datos en el archivo
                while (Reg != null) //mientras not EOF()
                {
                    /*los datos del Reg que se obtiene del archivo IDano de texto se 
                    asignan a las variables auxiliares locales para su facil manejo 
                    como posiciones del vector String*/
                    IDM = Reg[0];
                    nombre = Reg[1];
                    especie= Reg[2];
                    dueno = Reg[3];
                    genero = Reg[4];       

                    //si la ID que estamos buscando es igual a la ID que extraimos del archivo en Reg
                    if(idd.equalsIgnoreCase(dueno))
                    {cont++;}//fin si
                    //se lee el otro registro para que termine secuencialmente la lectura del archivo texto
                    Reg = objArch.LeerRegistro(5);
                }//fin mientras
                //cerramos el archivo IDano de texto en modo lectura
                objArch.CerrarArchivoModoLectura();
            }else{
                JOptionPane.showMessageDialog(null,"Dueño no encontrado.");
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }        
        return cont;
    }

    public CRUDMascota() {
    }
}
