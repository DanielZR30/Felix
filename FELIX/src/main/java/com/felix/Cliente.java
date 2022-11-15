/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

/**
 *
 * @author Usuario
 */
public class Cliente {
     private String ID,nombre,apellido,telefono,correo,direccion;

    public Cliente() {
    }

    public Cliente(String ID, String nombre, String apellido, String telefono, String correo, String direccion) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }
    
    public Cliente ingresarDatos(String ID)
    {
        setID(ID);
        nombre = Validaciones.leerString("Nombre: ");
        apellido = Validaciones.leerString("Apellido: ");
        telefono = Validaciones.leerString("Telefono: ");
        correo = Validaciones.leerString("Correo: ");
        direccion = Validaciones.leerString("Direccion: ");
        Cliente objc = new Cliente(ID,nombre,apellido,telefono,correo,direccion);
        return objc;
        
    }

    @Override
    public String toString() {
        return "Cliente\nID:" + ID + "\nNombre:" + nombre + "\nApellido:" + 
                apellido + "\nTelefono:" + telefono + "\nCorreo: " + correo + 
                "\nDireccion: " + direccion;
    }

    public String estructuraReg(){
        return ID + "," + nombre + "," + telefono +"," + correo + "," + direccion;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
