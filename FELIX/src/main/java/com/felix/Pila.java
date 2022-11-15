
package com.felix;

import javax.swing.JOptionPane;

public class Pila 
{
    //atributos propios y privados
    private int maxsize;//tamaño maximo del almacenamiento
    private int size;//contador de nodos para que no se pase de maximo tamaño
    private nodo top,q;//apuntador al tope y auxiliar q
    
    //constructores
    public Pila()
    {}
    public Pila(int n)//condiciones iniciales del constructor
    {
        maxsize=n;
        top=null;
        size=0;
    }
         
    public boolean IsEmpty() 
    {   //si esta vacia
        return getSize() <= 0;
    }
    
    public boolean IsFull() 
    {//si esta llena o sea ya se llego al maximo
        if(getSize() >= getMaxsize())
            return true;
        else 
            return false;
    }
    
          //  JOptionPane.showMessageDialog(null,"*****Pila LLena DESBORDAMIENTO DE PILA*****");//OPCIONAL
          
    public void Push(Object d)//apilar
    {
        if(IsFull()==false)//se van a colocar datos...problema?si esta llena
        {
            setSize(getSize() + 1);
            q=new nodo(d);
            q.setSig(getTop());
            setTop(q);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"*****Pila Llena DESBORDAMIENTO DE PILA*****");
              //(OPCIONAL);opcional avisarle al usuario pila LLENA
        }
        //opcional avisarle al usuario "pila LLENA..Desbordamiento de pila"
    }//fin de push - apilar
    
    public Object Pop()
    {
        Object d=null;
        if(IsEmpty()==false)//se van a quitar  datos...problema?si esta vacia
        {
            if (getTop().getSig() == null) 
            {
                d = getTop().getDato();
                setTop( null);
            } else {
                d =getTop().getDato();
                q=getTop();
                setTop(getTop().getSig());
                q=(null);
            }
            setSize(getSize() - 1);
        }    
        else
        {
            JOptionPane.showMessageDialog(null,"*****Pila Vacia SUBDESBORDAMIENTO DE PILA*****");
              //OPCIONAL);opcional avisarle al usuario pila VACIA
        }
        return d;
        
    }//fin  de pop - desapilar

    public Object  Peek()
    {
       Object dato=null; 
       if(IsEmpty()==false)
       {
           dato=getTop().getDato();
       }
      return dato;	
    }//Fin método pop

    public nodo getTop() {
        return top;
    }

    public void setTop(nodo top) {
        this.top = top;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}//fin clase pila
