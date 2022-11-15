/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

/**
 *
 * @author Usuario
 */
public class Mascota {
    private String ID,nombre,especie,dueno;

    public Mascota() {
    }

    public Mascota(String ID, String nombre, String especie, String dueno) {
        this.ID = ID;
        this.nombre = nombre;
        this.especie = especie;
        this.dueno = dueno;
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

    @Override
    public String toString() {
        return "Mascota:\nID:" + ID + "\nNombre:" + nombre + "\nEspecie=" + especie + "\nDueno=" + dueno;
    }
    
    
    
}
