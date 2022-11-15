/*
----------------
      Nodo 
----------------
-Dato: objeto
- sig: Nodo
- ant: Nodo
----------------
Nodo()
Nodo(d)
Nodo(li,d,ld)
----------------

*/

package com.felix;

import java.util.logging.Level;
import java.util.logging.Logger;

 
public class nodo  
{
   
    //atributos propios de la clase
    
    private Object dato;
    private nodo sig, ant;
   
    
//constructor vacio
    public nodo()
    {} 
    //fin método Nodo

    /*constructor que recibe el dato 
    y lo coloca en el nodo con su información
     y coloca las ligas en null*/
    public nodo(Object d)
    {
        dato=d;
        sig=null;
        
    }//fin método Nodo
    
    /*constructor para lista doble y arboles binarios
    recibe las tres partes del nodo y las asigna*/
    //solo para nodo doble
    public nodo(nodo li, Object d,nodo ld)
    {
        dato=d;
        sig=ld;
        ant=li;
    }//fin método nodo

    
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    //destructor ojo, este metodo finalize se  genera, es el inicio de un constructor
    public void finalize()
    {   try {
        super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(nodo.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   
     
    @Override
    public String toString() {
        return getDato().toString();
    }

    public nodo getAnt() {
        return ant;
    }

    public void setAnt(nodo ant) {
        this.ant = ant;
    }

       public nodo getSig() {
        return sig;
    }

    public void setSig(nodo sig) {
        this.sig = sig;
    }


         
}//fin clase nodo


    

