package com.felix;

import java.time.LocalDate;
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
    fecha en dia,mes,año y lo retorna como tipo de dato LocalDate*/
     public static LocalDate leerfecha(String mensaje) {
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
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        //se pasa el String a LocalDate que es el tipo de fecha sin hora
        LocalDate fecha = LocalDate.parse(Cfecha, formato); 
        return fecha;
    }
     
     public static String LeerGenero()
     {
        //lectura de genero, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé gen con las opciones que necesito
        Object [] gen ={"femenino","masculino","Otro"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Se identifica con Género:", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,gen, gen[0]);
           //se pide la variable opciones para pasarlo a genero que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String Genero=opciones.toString();//pasamos la opcion tipo Object a string
        return Genero;
     }//fin de leer genero
     
     public static String LeerNivelEstudios()
     {
        //lectura de nivel de estudios, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé niv con las opciones que necesito
        Object [] niv ={"Bachiller","Pregrado","Postgrado","Maestría","Doctorado","Otro"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Nivel de estudios: ", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,niv, niv[0]);
           //se pide la variable opciones para pasarlo a nivel que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String nivelE=opciones.toString();//pasamos la opcion tipo Object a string
        return nivelE;
     }//fin de leer nivel de estudios
     
     //calcula y retorna la edad en años recibiendo la fecha de nacimiento sin el tiempo 
     public static int CalcularEdad(LocalDate fn)
     {
         int AN;//variable para extraer el año de la fecha de nacimiento
         AN=fn.getYear();//se toma de la fecha solo el año
         int ed=ObtenerAActual()-AN;//se calcula la edad de acuerdo al año actual
         return ed;
     }//fin de calcular edad
     
      public static String LeerTipoCaja()
     {
        //lectura de tipo de caja, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé tic con las opciones que necesito
        Object [] tic ={"Automático","Manual"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Tipo de caja: ", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,tic, tic[0]);
           //se pide la variable opciones para pasarlo a nivel que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String tipoC=opciones.toString();//pasamos la opcion tipo Object a string
        return tipoC;
     }//fin de leer tipo de caja
     
      public static String LeerEstado()
     {
        Object opciones;
        Object [] est ={"Activo","Inactivo"};
        do{
           opciones = JOptionPane.showInputDialog(null,"estado de la Reserva: ", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,est, est[0]);
        }while(opciones==null);
        String estado=opciones.toString();
        return estado;
     }//fin de leer estado
      
       public static String LeerGama()
     {
        //lectura de gama, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé gen con las opciones que necesito
        Object [] gam ={"Alta","Media","Baja","Otra"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Gama:", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,gam, gam[0]);
           //se pide la variable opciones para pasarlo a gama que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String Gama=opciones.toString();//pasamos la opcion tipo Object a string
        return Gama;
     }//fin de leer gama
       
       /*Los combustibles
Combustibles gaseosos: hidrocarburos (metano, etano, butano,…).
Combustibles líquidos: derivados del petróleo (gasóleo, gasolina, queroseno,…) y alcoholes (metanol, etanol,…).
Combustibles sólidos: carbón (mineral y vegetal), coque y biomasa.*/
       public static String LeerCombustible()
     {
        //lectura de combustible, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé gen con las opciones que necesito
        Object [] com ={"Sólido","Líquido","Gaseoso","Otro"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Tipo de combustible:", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,com, com[0]);
           //se pide la variable opciones para pasarlo a combustible que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String combustible=opciones.toString();//pasamos la opcion tipo Object a string
        return combustible;
     }//fin de leer combustible
       
       /*A1:Motocicletas con cilindrada hasta 125 c.c.
A2:Motocicletas, motocicletas y moto triciclos con cilindrada mayor a 125 c.c.
B1: Automóviles, motocarros, cuatrimotos, camperos, camionetas y microbuses de servicio particular.
B2: Camiones rígidos, busetas y buses de servicio particular.
B3: Vehículos articulados servicio particular.
C1: Automóviles, camperos, camionetas y microbuses de servicio público.
C2: Camiones rígidos, busetas y buses de servicio público.
C3: Vehículos articulados servicio público.
*/
 public static String LeerCategoria()
     {
        //lectura de categoria de la licencia, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé cat con las opciones que necesito
        Object [] cat ={"A1","A2","B1","B2","B3","C1","C2","C3"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Categoria de la licencia:", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,cat, cat[0]);
           //se pide la variable opciones para pasarlo a categoria que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String categoria=opciones.toString();//pasamos la opcion tipo Object a string
        return categoria;
     }//fin de leer categoria   
}//fin de validaciones
