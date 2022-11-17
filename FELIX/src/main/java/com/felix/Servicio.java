/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Usuario
 */
public class Servicio {
    
    
    private boolean cancelado,asistido;
    private String ID,tipo,IDMascota,observaciones;
    private LocalDateTime FechaAsignada;
    private double precio;
    
    
    //auxiliar
    //formato para fechas
    DateTimeFormatter formato =DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    

    public Servicio() {
    }

    public Servicio(String ID,String IDMascota, String tipo, String observaciones, LocalDateTime FechaAsignada,double precio,boolean cancelado, boolean asistido) {
        this.cancelado = cancelado;
        this.asistido = asistido;
        this.ID = ID;
        this.tipo = tipo;
        this.IDMascota = IDMascota;
        this.observaciones = observaciones;
        this.FechaAsignada = FechaAsignada;
        this.precio = precio;
    }
    
    public Servicio ingresar(String IDM) {
        cancelado = false;
        asistido = false;
        tipo = Validaciones.LeerCategoria();
        IDMascota = IDM;
        FechaAsignada = Validaciones.leerFecha("Fecha:");
        observaciones = "";
        ID = generarID(IDMascota);
        precio = Validaciones.leerReal("Precio:");
        Servicio objs = new Servicio(ID,IDMascota,tipo,observaciones,FechaAsignada,precio,cancelado,asistido);
        return objs;
    }
    
    public String generarID(String IDM)
    {
        CRUDServicio objcm = new CRUDServicio();
        Archivos obja = new Archivos();
        int cont;
        cont = objcm.contarServicioMascota(obja, IDM);
        return IDM +"-"+ (cont+1);
    }

    @Override
    public String toString() {
        return "Servicio\nID:" + ID + "\nMascota:" + IDMascota  + 
                "\nTipo:" + tipo + "\nObservaciones:" + observaciones + 
                "\nFecha:" + FechaAsignada + "\nPrecio:" + precio +
                "\nasistido:" + asistido + "\nCancelado:" + cancelado;
    }
    public String estructuraReg() {
        return ID + "," + IDMascota  + "," + tipo + "," + observaciones + 
                "," + FechaAsignada +","+precio+","+ asistido + "," + cancelado;
    }

    public String imprimirImportante() {
        return ID + ",Mascota" + IDMascota  + "," + tipo + 
                "," + FechaAsignada.format(formato) +","+precio+"\n";
    }
    
    
    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public boolean isAsistido() {
        return asistido;
    }

    public void setAsistido(boolean asistido) {
        this.asistido = asistido;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIDMascota() {
        return IDMascota;
    }

    public void setIDMascota(String IDMascota) {
        this.IDMascota = IDMascota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaAsignada() {
        return FechaAsignada;
    }

    public void setFechaAsignada(LocalDateTime FechaAsignada) {
        this.FechaAsignada = FechaAsignada;
    }
    
    
    
    
}
