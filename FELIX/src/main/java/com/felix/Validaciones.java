package com.felix;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Validaciones {

    //Metodo para leer numeros enteros
    public static int leerEntero(String mensaje) {
        int num = 0;
        do {
            try {

                num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                if (num <= 0) {
                    JOptionPane.showMessageDialog(null, "ERROR, el número debe ser mayor que cero");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR - OJO la Excepcion es: " + e);
            }
        } while (num <= 0);
        return num;
    }

    //Metodo para leer numeros reales
    public static double leerReal(String mensaje) {
        double num = 0;
        do {
            try {

                num = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                if (num <= 0) {
                    JOptionPane.showMessageDialog(null, "ERROR, el Numero debe ser mayor que cero");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR - OJO la Excepcion es: " + e);
            }
        } while (num <= 0);

        return (num);
    }
    //Metodo para leer cadenas de texto

    public static String leerString(String mensaje) {
        String cadena = "";
        do {
            try {

                cadena = JOptionPane.showInputDialog(mensaje);
                if (cadena.equals("")) {
                    JOptionPane.showMessageDialog(null, "ERROR, NO debe dejarla en blanco, \n¡DEBE ingresar informacion!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR - OJO la Excepcion es: " + e);
            }
        } while (cadena.equals(""));
        return cadena;
    }

     //metodo que toma del sistema el año y lo retorna
    
    public static int ObtenerAActual(){
        int AA;
        Calendar fecha=Calendar.getInstance();//se toma la fecha del sistema
        AA= fecha.get(Calendar.YEAR);
        return AA;
    }
    
    /*metodo que lee una fecha sin el campo de tiempo, la lee como String
    valida que no dejen en blanco el String, luego este String lo pasa a
    fecha en dia,mes,año y lo retorna como tipo de dato LocalDateTime*/
     public static LocalDateTime leerfecha(String mensaje) {
        String Cfecha = "";
        do {
            try {

                Cfecha = JOptionPane.showInputDialog(mensaje+ " (dd/MM/yyyy):");
                if (Cfecha.equals("")) {
                    JOptionPane.showMessageDialog(null, "ERROR, NO debe dejarla en blanco, \n¡DEBE ingresar informacion!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR - OJO la Excepcion es: " + e);
            }
        } while (Cfecha.equals(""));
        //lectura de entrada de teclado almacenada en String
        //se da el formato establecido       
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
        //se pasa el String a LocalDateTime que es el tipo de fecha sin hora
        LocalDateTime fecha = LocalDateTime.parse(Cfecha, formato); 
        return fecha;
    }
     
     public static String LeerGenero()
     {
        //lectura de genero, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé gen con las opciones que necesito
        Object [] gen ={"Hembra","Macho","Desconocido"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Género:", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,gen, gen[0]);
           //se pide la variable opciones para pasarlo a genero que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String Genero=opciones.toString();//pasamos la opcion tipo Object a string
        return Genero;
     }//fin de leer genero
     public static String LeerCategoria()
     {
        //lectura de genero, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé gen con las opciones que necesito
        Object [] tipo ={"Hembra","Macho","Desconocido"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Tipo:", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,tipo, tipo[0]);
           //se pide la variable opciones para pasarlo a genero que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String opcion=opciones.toString();//pasamos la opcion tipo Object a string
        return opcion;
     }//fin de leer genero
     
}//fin de validaciones
