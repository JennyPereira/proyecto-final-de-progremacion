
package proyectodeprograma;

import java.util.Arrays;
import java.util.Scanner;
/**
 * La clase "SisteDeReserva" fue creada para emitar el sistema de reserva de las salas
 * de computo de la UTPL.
 * Esta clase tiene métodos los cuales fueron creados para realizar ciertas tareas específicas 
 * como visualizar salas, registrar equipo, entre otros.
 * -Utiliza una clase 'Utilidades', la cual tiene dos métodos  get`s státicos: uno sirve
 * para leer enteros[Utilidades.leerInt()] y otra que sirve para leer datos del
 * tipo cadenas[Utilidades.leerString()].
 * @author Anthony Ortiz Ramón.
 * @author José Romero.
 * @author Jenny Pereira.
 * @author Hamilton Ramirez.
 */
public class SistemaDeReserva {
     
  Login sesion; //creación de un objeto Login.
  
  //Strings arreglos parar reprsentar las salas de cómputo.
  private  String salaA[]={"X","X","X","X","X","X"};
  private  String salaB[]={"X","X","X","X","X","X"};
  private  String salaC[]={"X","X","X","X","X","X"};
  private  String salaD[]={"X","X","X","X","X","X"};
  
  //Atributos que se utlizarán para que el estudiante pueda liberar la máquina.
  private  boolean equipoRegistrado[]={false,false,false}; //Permitira ver si un estudiante tiene un equipo registrado.
  private  int numeroEquipo[]={0,0,0};//Se utilizará para asignar a cada estudiante el equipo que eligió. 
  private  String salaDelEstudiante[]={"-","-","-"};//Se utilizará para asignar a cada estudiante la sala que haya elegidó.
  private  int contE;//Servira para identificar que estudiante quiera liberar el equipo que eligió.
  private  boolean salir;//Este atributo sirvira para salir de la interfaz del estudiante o cuando  registro un eqipo disponible.
     /**
      * Constructor de la clase SistyemaDeReserva.
      */   
     public SistemaDeReserva(){
         sesion  = new Login();
     } 
     /**
      * Se encarga de ejecutar y verificar el método [isPeticionDatos()] del objeto,
      * 'sesion' de la clase 'Login'.
      * @return acceso boolean, obtiene el valor de 'true' si la condicion es verdadera,
      * caso contrarios se queda con su valor original 'false'.
      */
     public boolean isTieneAcceso(){
         boolean acceso = false;
         if (sesion.isPeticionDatos() == true) {
             acceso = true;
         }
         return acceso;
     }  
      
    //-----------------------------------ADMINISTRADOR----------------------------------------
    /**
     * Este método se encarga de mostrar un menú del administrador y de ejecutar
     * las opciones(métodos) del mismo.
     */
    public void interfazAdministrador(){
            String opcion;
            boolean salir;
            
            do{
            salir=false;
            System.out.println("           UNIVERSIDAD TÉCNICA PARTICULAR DE LOJA");
            System.out.println("         |=========================================|");
            System.out.println("         |Opción[1]: visualizar sala(s) de cómputo |");
            System.out.println("         |Opción[2]: suspender equipo dañado       |");
            System.out.println("         |Opción[3]: habilitar sala(s)             |");
            System.out.println("         |Opción[4]: deshabilitar sala(s)          |");
            System.out.println("         |Opción[5]: permitir ingreso              |");
            System.out.println("         |=========================================|");
            System.out.print("Opción: ");
                              opcion=Utilidades.leerString();
                      switch (opcion){
                                     case "1": verDisponibilidadSalas(); visualizarSalas(); break;                     
                                     case "2": suspenderEquipo(); break;
                                     case "3": habilitarSala();break;
                                     case "4": desabilititarSala();break;
                                     case "5": salir = true;break;
                                     default:System.out.println("¡Esta opción no existe!");
                      }//Fin switch 
            }while(salir==false);
    }
    
    /**
     * Este método se encarga de mostrar la disponibilidad de las salas con ayuda          
     * de otro metodo[isSalaDisponible()] que verifica si cada sala esta ocupada o no. 
     */
    private void verDisponibilidadSalas(){
        System.out.println("-----------------------------------------------------");
        if (isSalaDisponible(salaA)) {
            System.out.print("  Sala A: Disponible          ");
        }else{
            System.out.print("  Sala A: No Disponible       ");
        }

        if (isSalaDisponible(salaB)) {
            System.out.println("Sala B: Disponible");
        }else{
            System.out.println("Sala B: No disponible");
        }
        
        if (isSalaDisponible(salaC)) {
            System.out.print("  Sala C: Disponible          ");
        }else{
            System.out.print("  Sala C: No disponible       ");
        }
        
        if (isSalaDisponible(salaD)) {
            System.out.println("Sala D: Disponible");
        }else{
            System.out.println("Sala D: No disponible");
        }
        System.out.println("-----------------------------------------------------");
    }
    
    //Primera opción
    /**
     * Su funcionalidad es de solicitar al usuario que ingrese una sala para poder 
     * mostrarla con la adyuda del método[mostrarSala()].
     * -mostrarSala() se encuntra mas abajo de este método.
     */
    private void visualizarSalas(){
            String sala;
            System.out.print("Ingrese la sala: ");
            sala=Utilidades.leerString();
            switch(sala){
                //Metodo mostrarSala() se encuentra mas abajo.
                case "a": mostrarSala(this.salaA);break;
                case "b": mostrarSala(this.salaB);break;
                case "c": mostrarSala(this.salaC);break;
                case "d": mostrarSala(this.salaD);break;
                default:System.out.println("¡Esta sala no existe!");
            }
    }
    /** 
     * Su función principal es la de mostrar un arreglo en forma de matriz para que
     * tenga la forma de una 'sala' de cómputo. 
     * @param sala String(arreglo), obtenido del dato que el usuario ingreso en el 
     * método visualizarSalas().
     */
    private void mostrarSala(String sala[]){
            System.out.println("              ------------------");
            System.out.print("                  ");
            for (int i = 0; i < sala.length; i++) {                          
                System.out.print("["+sala[i]+"] ");
                if (i==2) {
                    System.out.println("");
                    System.out.print("                  ");
                }             
            }
            System.out.print("\n              ------------------\n");
    }
    //FIN Primera opción
    
    //Segunda opción
    /**
     * La funcionalidad de este método es de solicitar al usuario la sala en donde 
     * se suspendera el equipo, después dependiendo de la sala que se indicó se llama
     * al método[setEquipoDañado()].
     * -setEquipoDañado() se encuentra de bajo de este método.
     */
    private void suspenderEquipo(){
            String sala,respuesta;
            System.out.println("--------------------------------------------");
            do{          
                System.out.print("Ingrese la sala: ");
                sala=Utilidades.leerString();
                switch(sala){
                    case "a": setEquipoDañado(salaA);break;
                    case "b": setEquipoDañado(salaB);break;
                    case "c": setEquipoDañado(salaC);break;
                    case "d": setEquipoDañado(salaD);break;
                 default: System.out.println("¡Esta sala no existe!");
                }
                System.out.print("Ingresar a otra sala(si/no): ");
                respuesta=Utilidades.leerString();
            } while(respuesta.equals("si"));
   }
    /**
     * Se encarga de solicitar el equipo que el 'usuario' quiera suspender en la sala
     * que se haya específicado en el método[suspender()].
     * @param sala String(arreglo), obtenido de la 'sala' que el 'usuario' haya ingresado
     * en el método[suspender()].
     */
    private void setEquipoDañado(String sala[]){
            Scanner teclado1 = new Scanner(System.in);
            String respuesta;
            int equipo;
            do{
                System.out.print("Equipo: ");
                equipo=teclado1.nextInt();
                System.out.print("Confirmar(si/no): ");
                respuesta=Utilidades.leerString();               
                if (respuesta.equals("si")) {
                     if (equipo > 0 && equipo < 7) {
                            sala[equipo-1]="D";                        
                     }else{
                            System.out.println("¡Este equipo no existe!");
                     }                 
                }            
                System.out.print("Registrar otro(si/no):");
                respuesta=Utilidades.leerString();                 
            }while(respuesta.equals("si"));
    }
    //FIN Segunda opción
    
    
    //Tercera opción 
    /**
     * Su funcionalidad es la de solicitar al usuario que ingrese una sala para 
     * habilitarla, una ves que haya ingresado la sala, llama a un método[setSala()]
     * para poder habilitar la sala que se haya indicado.
     * -setSala() se encuentra abajo de este método.
     */
    private void habilitarSala(){
        String sala, respuesta;
        System.out.println("--------------------------------------------");
        do{
            System.out.print("Ingrese la sala: ");
            sala=Utilidades.leerString();
            switch(sala){
                case "a": setSala(salaA);break;
                case "b": setSala(salaB);break;
                case "c": setSala(salaC);break;
                case "d": setSala(salaD);break;
                default:System.out.println("¡Esta sala no existe!");
            }
            System.out.print("Desea habilitar otra sala(si/no): ");
            respuesta=Utilidades.leerString();
        }while(respuesta.equals("si"));
     } 
    /**
     * Este método se encarga de recorre un arreglo que es la sala que se indicó en el
     * método[habilitarSala()] y asignarle un número de equipo a cada elemento del 
     * arreglo(sala) con un FOR.
     * @param sala String(arreglo), obtenino del dato que el 'usuario' haya indicado en 
     * el método[habilitarSala()].   
     */
    private void setSala(String sala[]){
        for (int i = 0; i < sala.length; i++) {
            if (!sala[i].equals("D")) {
                sala[i]=Integer.toString(i+1);
            }
        }
    }
    //FIN Tercera opción 
    
    //Cuarta opción
    /**
     * La funcionalidad de este método es la de solicitar una sala al 'usuario' para 
     * deshabilitarla, después el método[fill()] llena el arreglo(sala) con el caracter ´X´
     * en la sala que se haya indicadó(esto da entender que los equipos ya no estan disponibles).
     */
    private void desabilititarSala(){
        String sala, respuesta;        
        System.out.println("--------------------------------------------");
        do{
            System.out.print("Ingrese la sala: ");
            sala=Utilidades.leerString();
            switch(sala){
                case "a": Arrays.fill(salaA, "X");break;
                case "b": Arrays.fill(salaB, "X");break;
                case "c": Arrays.fill(salaC, "X");break;
                case "d": Arrays.fill(salaD, "X");break;
                default:System.out.println("¡Esta sala no existe!");
            }
            System.out.print("Desea habilitar otra sala(si/no): ");
            respuesta=Utilidades.leerString();
        }while(respuesta.equals("si"));        
    }
    //FIN Cuarta opción
    //-----------------------------------ADMIN--------------------------------------------
    
    
    //----------------------------------ESTUDIANTE---------------------------------------
    /**
     * Su funcionalidad se encarga de mostrar el menú del estudiante y de ejecutar
     * las opciones(métodos) del mismo. Ademas ejecuta un método[isTieneEquiopoRegistrado()]
     * el cual verifica si el estudiante que ingreso a la sesión tiene registrado un equipo
     * si el método retorna 'false' entramos a la interfdaz, caso contrario libera el equipo 
     * del estudiante.
     * -isTieneEquiopoRegistrado() se encuntra a bajo de este método.
     */
    public void interfazEstudiante(){
        String opcion;  
        
            if(isTieneEquiopoRegistrado() == false){
                
                do{
                         this.salir=false;
                         System.out.println("   |==========================================|");
                         System.out.println("   |Opción[1]: ver disponibilidad de las salas|");
                         System.out.println("   |Opción[2]: registrar equipo               |");
                         System.out.println("   |Opción[3]: salir                          |");
                         System.out.println("   |==========================================|");
                         System.out.print("Opción: ");
                        opcion = Utilidades.leerString();
                             switch(opcion){
                                 case "1": verDisponibilidadSalas(); break;
                                 case "2": registrarEquipo();break;
                                 case "3": this.salir=true;break;
                                 default:System.out.println("¡Esta opción no existe!");
                             }
                }while(this.salir==false);
            }else if(isTieneEquiopoRegistrado() == true){
                
                String sala = salaDelEstudiante[contE];//se asigna la sala del estudiante(contE).  
                int eqipoRegistrado =  numeroEquipo[contE];//se asigna el equipo del estudiante(contE).
                liberarEquipo(sala,eqipoRegistrado);//Este método se encuentra mas a bajo.   
                
                System.out.println("El equipo se a liberado");
                equipoRegistrado[contE] = false;//El equio registrado el estudiante(contE) se pone  en 
                                                //'false' para indicar que el estudiante 
                                                //ya no tiene un equipo registrado.
            }
          
    }    
    /**
     * Este método se encarga de verificar si un 'estudiante' tiene un equipo registrado.
     * El método recorre un FOR para ver si el átributo'nombre' del estudiante que ingreso a la sesión
     * coincide con uno del arreglo 'nombreEstudiante' y también verifica si no tiene equipo registrado.
     * Para que este método tenga que ejecutarse correctamente, primero se debe ejecutar el método[isPeticionDatos()]
     * del objeto 'sesion'.
     * @return tieneEquipo boolean, obtiene el valor de 'true' si la primera condicion es verdadera, caso 
     * contrario retorna su valor original 'false'.
     */
    private boolean isTieneEquiopoRegistrado(){
            boolean tieneEquipo = true;
            for (int i = 0; i < 3; i++) {
                if ( sesion.nombre.equals(sesion.nombreEstudiante[i]) && equipoRegistrado[i]==false ) {
                    tieneEquipo = false;
                    contE=i;
                   return tieneEquipo;
                }else if (sesion.nombre.equals(sesion.nombreEstudiante[i]) && equipoRegistrado[i]==true){
                    contE=i;
                }   
            }         
         return tieneEquipo;
     }
    /**
     * Su funcionalidad es la de liberar el equipo que el estudiante registro.
     * Este método se ejecuta en el método[interfazEstudiante()]- despues de la condición 
     * if(isTieneEquiopoRegistrado() == true). Dependiendo de la sala que el estudiante
     * haya registrado el equipo, este método se encargara de liberarlo con los datos obtenidos
     * en la condición if(isTieneEquiopoRegistrado() == true).
     * @param sala String, obtenido en la condición del método [interfazEstudiante()].
     * @param equipoRegistrado int, obtenido en la condición del método [interfazEstudiante()].
     */
    private void liberarEquipo(String sala, int equipoRegistrado){
         switch (sala){
             case "a": salaA[equipoRegistrado-1]=Integer.toString(equipoRegistrado);break;
             case "b": salaB[equipoRegistrado-1]=Integer.toString(equipoRegistrado);break;
             case "c": salaC[equipoRegistrado-1]=Integer.toString(equipoRegistrado);break;
             case "d": salaD[equipoRegistrado-1]=Integer.toString(equipoRegistrado);break;
         }
     }
    
    //Segunda opción estudainte
    /**
     * Su principal función es la de registrar un equipo en una salsa de cómputo.
     * Este método solicita al 'estudiante' la sala donde quiera registrar el equipo
     * que desea ocupar. Depués llama al método[setEquipo()].
     * -setEquipo() se encuntra más a bajo de este método.
     */
    public void registrarEquipo(){
        String sala;
        System.out.println("--------------------------------------------");
            System.out.print("Ingrese la sala: "); 
            sala=Utilidades.leerString();
            salaDelEstudiante[contE]=sala;
            switch(sala){
                //El metodo setRegistroEn() se encuentra mas abajo.
                case "a": setEquipo(salaA);break;
                case "b": setEquipo(salaB);break;
                case "c": setEquipo(salaC);break;
                case "d": setEquipo(salaD);break;
                default:System.out.println("¡Esta sala no existe!");            
            }
    }
    /**
     * Este método se encarga de solicitar y registrar un equipo. 
     * Solicita al estudiante que ingrese el equipo que desea ocupar, una ves ingresado el dato 
     * el método se encaga de actualizar al arreglo(sala) con '0' para dar a entender que ese equipo
     * ya esta ocupado.
     * @param sala String(arreglo), obtenido del método[registrarEquipo()].
     */
    private void setEquipo(String sala[]){
        int equipo;
        String respuesta;
        boolean salir;
        if(isSalaDisponible(sala)){
            mostrarSala(sala);
            System.out.print("Ingrese el equipo: ");
            equipo=Utilidades.leerInt();
                                                                              
                        if (sala[equipo-1].equals(Integer.toString(equipo))) {
                            System.out.print("Confirmar(si/no): ");
                            respuesta=Utilidades.leerString();    
                            if (respuesta.equals("si")) {  
                             sala[equipo-1]="0";
                             this.salir=true;
                             mostrarSala(sala);
                             System.out.println(sesion.nombre+" Máquina ["+ equipo+"]"+" reservada");
                             //Actualización de los atributos para que el estudiante pueda liberar el equipo.
                             numeroEquipo[contE] = equipo;//se asigna el equipo ingrersado con el 
                                                          //estudiante específicado(contE).
                             equipoRegistrado[contE] = true;//se asigna valor 'true' para indicar que el estudiante
                                                            //ya tiene un equipo registrado.
                            }
                         }else {
                                if(sala[equipo-1].equals("0")){
                                    System.out.println("¡Este equipo no esta disponible!");                                  
                                }else if(sala[equipo-1].equals("D")) {                        
                                    System.out.println("¡Este equipo esta dañado!");
                                 }                 
                        }
       
       } else{
            System.out.println("¡Esta sala no esta dispopnible!");    
       }
    }        
    //FIN Segunda opción estudainte    
    //----------------------------------ESTUDIANTE------------------------------   
     
    /**
     * Este método se encarga de verificar la disponibilidad de una sala.
     * Recorre un arreglo(sala) el cual verifica cada elemento.Si la primera
     * condición cumple para todos los elementos se entendera que el arreglo(sala)
     * esta ocupada.
     * @param sala String(arreglo), obtenido  de algunos métodos conmo [verDisponibilidadSalas()]
     * y setEquipo().
     * @return disponibilidad boolean, obtiene el valor de 'false' si la primera condición se cumple
     * para cada elemento del arreglo(sala) caso contrario tendar su valor de origen 'true'.
     */
    private boolean isSalaDisponible(String sala[]){
        boolean disponibilidad=true;
        int n=0;
        for (int i = 0; i < sala.length; i++) {
            if (sala[i].equals("X")||sala[i].equals("D")||sala[i].equals("0")) {
                n+=1;
            }
        }
        if (n==6) {
            disponibilidad=false;
        }
        return disponibilidad;
    }
}
