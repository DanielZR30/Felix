/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felix;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Servicio {
    private boolean cancelado,asistido;
    private String ID,tipo,IDMascota,observaciones;
    private LocalDate FechaAsignada;
    private double precio;

    public Servicio() {
    }

    public Servicio(boolean cancelado, boolean asistido, String ID, String tipo, String IDMascota, String observaciones, LocalDate FechaAsignada,double precio) {
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
        FechaAsignada = Validaciones.leerfecha("Fecha:");
        observaciones = "";
        ID = generarID(IDMascota);
        precio = Validaciones.leerReal("Precio:");
        Servicio objs = new Servicio();
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

    public LocalDate getFechaAsignada() {
        return FechaAsignada;
    }

    public void setFechaAsignada(LocalDate FechaAsignada) {
        this.FechaAsignada = FechaAsignada;
    }
    
    
    
    
}
