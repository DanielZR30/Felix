package com.felix;

import javax.swing.JOptionPane;

public class Cola 
{
    //atributos propios y privados
    private int maxsize;//tamaño maximo del almacenamiento
    private int size;//contador de nodos para que no se pase de maximo tamaño
    private  nodo Final,Front,q;//apuntador a la cabeza de la fila y  apuntador a la cola de la fila y q auxiliar
    
    //constructores
    public Cola()
    {}
    public Cola(int n)//condiciones iniciales del constructor
    {
        maxsize=n;
        Final=null;
        Front=null;
        size=0;
        
    }
        
    public boolean IsEmpty() 
    {//si esta vacia
        if(getSize()<= 0)
            return true;
        else
            return false;
    }

    public boolean IsFull() 
    {//si esta llena o sea ya se llego al maximo
        if(getSize()>= getMaxsize())
            return true;
        else 
            return false;
    }
           
    public void Push(Object d)//encolar
    {
        if (IsFull()==false)//se le puede ingresar informacion
        { 
            setSize(getSize() + 1);
            q=new nodo(d);
            if(Front==null)//si es el primer dato
               {
                setFront(q);
                setFinal(q) ;
                }
             else//si ya hay un dato
                {
                 getFinal().setSig(q);
                 setFinal(q);
                }//fin si 
        }//fin si
        else
        {
        //sino pila llena//  
            JOptionPane.showMessageDialog(null,"*****Pila LLena DESBORDAMIENTO DE PILA*****");//OPCIONAL//opcional
        }
    }//fin de push - encolar
    
    public Object Pop()//desencolar
    {
        Object d=null;
        if (IsEmpty()==false)
        {
            setSize(getSize() - 1);
            if(Front==Final)
            {
                d = getFront().getDato();
                setFront(null);
                setFinal(null);
            }
            else
            {
                d =getFront().getDato();
                q=getFront();
                setFront(getFront().getSig());
                q=(null);
            }
            }
        else
        {
        //sino pila vacia//  
            JOptionPane.showMessageDialog(null,"*****Pila Vacia SUBDESBORDAMIENTO DE PILA*****");//OPCIONAL
        }
        
        return d;
    }//fin de pop - encolar

    public Object  Peek()
    {
       Object dato=null; 
       if(IsEmpty()==false)
       {
           dato=getFront().getDato();
       }
       return dato;
    }//Fin método peek


   public nodo getFront() {
        return Front;
    }

    public void setFront(nodo Front) {
        this.Front = Front;
    }
    public nodo getFinal() {
        return Final;
    }

    public void setFinal(nodo Final) {
        this.Final = Final;
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

   
}//fin clase cola
