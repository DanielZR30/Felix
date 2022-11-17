/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Mascota {
    private String ID,nombre,especie,dueno,genero;
    
    public Mascota() {
    }

    public Mascota(String ID, String nombre, String especie, String dueno,String genero) {
        this.ID = ID;
        this.nombre = nombre;
        this.especie = especie;
        this.dueno = dueno;
        this.genero = genero;
    }
    
    public Mascota ingresarDatos(String IDD)
    {
        int option;
        nombre = Validaciones.leerString("Nombre de la mascota: ");
        especie = Validaciones.leerString("Especie: ");
        dueno = IDD;
        option = JOptionPane.showConfirmDialog(null,"Desea agregar una identificación","Agregar mascota", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            ID = Validaciones.leerString("Identificacion:");
        }else{
           ID = generarID(dueno); 
        }
        
        genero = Validaciones.LeerGenero();
        Mascota objm = new Mascota(ID,nombre,especie,dueno,genero);
        return objm;
        
    }
    
    public String generarID(String IDD)
    {
        CRUDMascota objcm = new CRUDMascota();
        Archivos obja = new Archivos();
        int cont;
        cont = objcm.contarMascotasDueno(obja, IDD);
        return IDD +"-"+ (cont+1);
    }
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Mascota:\nID:" + ID + "\nNombre:" + nombre + "\nEspecie=" 
                + especie + "\nDueno:" + dueno + "\nGenero:"+genero;
    }
    
    public String estructuraReg() {
        return  ID + "," + nombre + "," + especie + "," + dueno + ","+genero;
    }
    
    
    
}
