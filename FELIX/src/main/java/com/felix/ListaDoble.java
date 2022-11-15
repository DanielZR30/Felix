package com.felix;

import javax.swing.JOptionPane;

public class ListaDoble 
{
    //atributos propios y privados
    private nodo Start, End;

    public ListaDoble() 
    {
        
        Start=null;//apuntador al primer nodo de la lista
        End=null;//apuntador al ultimo nodo de la lista
    }

      
    nodo q,p;//auxiliares
        
//si lista vacia o no    
    public boolean IsEmpty()
    {
       if (getStart()==null)  
            //"LISTA VACIA!!!“   //mensaje opcional
            return true;
        else
             return false;
        //fin si 
    }//fin esta vacia

  //el que se inserta queda de ultimo o sea apuntador end  
public void InsertarNodoPorFinal(Object info)
{
    if (IsEmpty()==false) {

            getEnd().setSig(new nodo(End,info, null)); 
            setEnd(getEnd().getSig());

        } else {

            Start = End = new nodo(null,info, null);
        }
}//fin de insertar nodo por final
    
  //el que se inserta queda de primero o sea apuntador start        
public void InsertarNodoPorInicio(Object info)
{
    if (IsEmpty()==false) {
        setStart(new nodo(null,info,getStart()));
        getStart().getSig().setAnt(getStart());
            }
    else {

            Start = End = new nodo(null,info, null);
        }
    
}//fin de insertar nodo por inicio
    
//retorna una cadena con toda la informacion de la lista desde el inicio    
public String InfoDesdeInicio()
    {
     String texto=" ";
     if(IsEmpty()==false)
     {
      q=getStart(); 
      while(q!=null)  
      {
         texto =texto+q.toString(); //q.obtenerDato()
         q=q.getSig();
      }//fin mientras
     }
     
    //Fin si
    return texto;
    }//Fin imprimir

//retorna una cadena con toda la informacion de la lista desde el final 
public String InfoDesdeFinal()
{          
 String texto=" ";
     if(IsEmpty()==false)
     {
      q=End;
      while(q!=null)  
      {    
           texto =texto+q.toString();//fin.obtenerDato()
           q=q.getAnt(); 
      }//fin mientras
      }
      
    //Fin si
return texto;
}//fin imprimir

//libera el primer nodo de la lista
public Object LiberarInicio()
{
    Object dato=null;
    if(IsEmpty()==false)//si hay dato en la lista
    {
        dato=getStart().getDato();
        if(getStart().getSig()==null)//si es una lista de un solo nodo
        {
            getStart().finalize();
            setStart(null);
            setEnd(null);
            JOptionPane.showMessageDialog(null,"la lista quedo vacia!!");
        }
        else
        {
            setStart(getStart().getSig());
            getStart().getAnt().finalize();
            getStart().setAnt(null);
        }//fin si
     }//fin si
    return dato; 
}//fin de liberar inicio

//libera el ultimo nodo de la lista
public Object LiberarFinal()
{
    Object dato=null;
    if(IsEmpty()==false)//si hay dato en la lista
    {
        dato=getEnd().getDato();
        if(getEnd().getAnt()==null)//si es una lista de un solo nodo
        {
            getEnd().finalize();
            setStart(null);
            setEnd(null);
            JOptionPane.showMessageDialog(null,"la lista quedo vacia!!");
        }
        else
        {
            setEnd(getEnd().getAnt());
            getEnd().getSig().finalize();
            getEnd().setSig(null);
        }//fin si
     }//fin si
    return dato; 
}//fin de liberar final

//encapsular los campos
    public nodo getStart() {
        return Start;
    }

    public void setStart(nodo Start) {
        this.Start = Start;
    }

    public nodo getEnd() {
        return End;
    }

    public void setEnd(nodo End) {
        this.End = End;
    }

   
}//fin de la clase lista
